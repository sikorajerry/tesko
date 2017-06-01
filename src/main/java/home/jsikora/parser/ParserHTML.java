package home.jsikora.parser;



import home.jsikora.dto.ProductCzIkeaDTO;
import home.jsikora.dto.ProductPlIkeaDTO;
import home.jsikora.repository.CzIkeaRepository;
import home.jsikora.repository.PlIkeaRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungsam on 23.5.17.
 */
@Component
public class ParserHTML {
    private static final Logger log = LoggerFactory.getLogger(ParserHTML.class);

    @Autowired
    private CzIkeaRepository czIkeaRepository;

    @Autowired
    private PlIkeaRepository plIkeaRepository;

    private List<String> spatneZaznamy = new ArrayList<>();

  //TODO vratit List<DTO> nebo ulozit ??
    public void parserHtmlPage(String page,String country) {
        log.info("ParserHTML.parserHtmlPage("+page+")");
        Document doc = null;


        try {
            doc = Jsoup.connect(page).get();
            String title = doc.title();
            log.info("docTitle - "+ title);
            Elements content = doc.getElementsByClass("productsAzLink");


            for(Element element: content) {
                String nazev = element.text(); //nazev vyrobku

                Element link = element.select("a").first();  //prvni a jediny tag a
                String productFromLink = link.attr("href"); //vyctu hodnotu href "/cz/cs/catalog/products/60158304/"
               // path = link.attr("abs:href"); cela path i s domenou
                String vyrobek = productFromLink.substring(24,productFromLink.length()-1);
                String cena ;
                if ((nazev.substring(0,3).equals(nazev.substring(0,3).toUpperCase()))) {

                     cena = this.parseHtmlForDetailPrice(link.attr("abs:href"));
                }  else {
                    cena = "zero";
                }
                //log.info(productFromLink+ " " + vyrobek + " " +nazev +" "+ cena);//+element.toString()

                //Todo ale zde udelam metodu na okamzite ulozeni do databaze
                if (vyrobek.isEmpty() || cena.isEmpty() || nazev.isEmpty() || cena.equals("zero")) {
                    spatneZaznamy.add("vyrobek : " + vyrobek+", nazev : "+nazev+", cena"+cena);

                } else {
                    if (country.equals("cz")) {
                        String cenaUpravena = cena.substring(0,cena.length()-2);

                        if(cenaUpravena.length()>3) {
                           cenaUpravena = this.upravitCenuProCz(cenaUpravena);
                        }

                        czIkeaRepository.save(new ProductCzIkeaDTO(vyrobek,nazev,Double.parseDouble(cenaUpravena)));
                    } else if (country.equals("pl")) {
                        String cenaUpravena = cena.substring(0,cena.indexOf("PLN")-1);
                        cenaUpravena = cenaUpravena.replace(",",".");
                        if(cenaUpravena.length()>3) {
                            cenaUpravena = this.upravitCenuProCz(cenaUpravena);
                        }

                        plIkeaRepository.save(new ProductPlIkeaDTO(vyrobek,nazev,Double.parseDouble(cenaUpravena)));
                    }


                }

            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : spatneZaznamy) {
            log.warn(s);
        }



    }

    private String parseHtmlForDetailPrice(String url) throws IOException {
        String cena = "zero";
        Document doc = null;

        doc = Jsoup.connect(url).get();

        Element content = doc.getElementsByClass("packagePrice").first();
        if (content !=null) {
            //log.info("element in not null");
            cena =  content.text();
        } else {
            //log.warn("element NOT FOUND");

        }


        return cena;
    }

    private String upravitCenuProCz(String cenaUpravena) {
        String vystup="";
        char[] myNameChars = cenaUpravena.toCharArray();
        char tecka='.';

        for (int i = 0; i < myNameChars.length; i++) {
            if (myNameChars[i]==tecka) {

                vystup +=tecka;
            } else if (Character.getNumericValue(myNameChars[i])== -1) {

            } else {
                vystup += myNameChars[i];
            }
        }
        return vystup;
    }


}
