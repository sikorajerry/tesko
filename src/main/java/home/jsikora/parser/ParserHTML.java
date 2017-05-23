package home.jsikora.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by sungsam on 23.5.17.
 */
@Component
public class ParserHTML {
    private static final Logger log = LoggerFactory.getLogger(ParserHTML.class);

    public void parserHtmlPage(String page) {
        log.info("ParserHTML.parserHtmlPage("+page+")");
        Document doc = null;


        try {
            doc = Jsoup.connect(page).get();
            String title = doc.title();
            log.info("docTitle - "+ title);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
