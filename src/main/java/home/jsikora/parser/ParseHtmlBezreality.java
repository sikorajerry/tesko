package home.jsikora.parser;

import home.jsikora.dto.BezrealityDTO;
import home.jsikora.repository.BezRealitkyRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by sungsam on 2.7.17.
 */
@Component
public class ParseHtmlBezreality {

    @Autowired
    private BezRealitkyRepository bezRealitkyRepository;

    private static final Logger log = LoggerFactory.getLogger(ParseHtmlBezreality.class);


    public void parsePage(String baseUrl) throws IOException {

        log.info("ParseHtmlBezreality " + baseUrl);
        BezrealityDTO bezrealityDTO = new BezrealityDTO();
        bezrealityDTO.setUrl(baseUrl);

        Document doc = Jsoup.connect(baseUrl).get();
        Elements newsHeadlines = doc.getElementsByClass("block-params");
        Element adresa = doc.getElementsByTag("h2").first();
        bezrealityDTO.setAdresa(adresa.html());

        for (Element element : newsHeadlines) {
            Elements key = element.getElementsByClass("key");
            Elements value = element.getElementsByClass("value");

            for (int i = 0; i < key.size(); i++) {

                switch (key.get(i).html()) {
                    case "číslo inzerátu:":
                        bezrealityDTO.setInzeratId(value.get(i).html());
                        break;
                    case "dispozice:":
                        bezrealityDTO.setDispozice(value.get(i).html());
                        break;
                    case "balkón:":
                        bezrealityDTO.setBalkon((value.get(i).html()).equals("Ano") ? true : false);
                        break;
                    case "terasa:":
                        bezrealityDTO.setTerasa((value.get(i).html()).equals("Ano") ? true : false);
                        break;
                    case "plocha:":
                        String plocha = value.get(i).html();
                        plocha = plocha.substring(0, plocha.length() - 3);
                        bezrealityDTO.setPlocha(Integer.parseInt(plocha));
                        break;
                    case "cena:":
                        String cena = value.get(i).html();
                        int index = cena.indexOf("K");
                        cena = cena.substring(0,index-1);

                        String cenaConverter="";
                        for(char c : cena.toCharArray()) {
                            if (Character.getNumericValue(c) != -1) {
                                cenaConverter+=c;
                            }

                        }
                        bezrealityDTO.setCena(Long.parseLong(cenaConverter));
                        break;
                    case "typ vlastnictví:":
                        bezrealityDTO.setVlastnictvi(value.get(i).html());
                        break;

                    case "typ nemovitosti:":
                        bezrealityDTO.setNemovitost(value.get(i).html());
                        break;

                }
            }

            log.info(bezrealityDTO.toString());
            bezRealitkyRepository.save(bezrealityDTO);

        }


    }
}
