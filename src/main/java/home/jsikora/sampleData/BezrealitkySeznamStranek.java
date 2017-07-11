package home.jsikora.sampleData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungsam on 2.7.17.
 */
@Component
public class BezrealitkySeznamStranek {

    private static final Logger log = LoggerFactory.getLogger(BezrealitkySeznamStranek.class);
    final int pocetStranek = 200;
    private String bezrealitky = "https://www.bezrealitky.cz/vypis/nabidka-prodej/byt/praha";

    private List<String> pagesGenerator = new ArrayList<>();
    private List<String> listPages = new ArrayList<>();


  /*  @PostConstruct
    public void initialize() {


        for (int i = 1; i < this.pocetStranek ; i++) {
            pagesGenerator.add(bezrealitky+"?page="+i);
            log.info(bezrealitky+"?page="+i);
        }

        for(String url : pagesGenerator) {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements newsHeadlines = doc.getElementsByClass("short-url");


                for(Element element : newsHeadlines) {
                    if (!element.html().equals("sdílet")) {
                        listPages.add(element.html());
                    }



                }
                log.info("Done "+url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    */

    public List<String> getListPages() {
        return listPages;
    }

    public void setListPages(List<String> listPages) {
        this.listPages = listPages;
    }
}
