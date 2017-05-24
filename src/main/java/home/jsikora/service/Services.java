package home.jsikora.service;

import home.jsikora.parser.ParserHTML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by sungsam on 23.5.17.
 */
@Service
public class Services {

    private static final Logger log = LoggerFactory.getLogger(Services.class);

    @Autowired
    private ParserHTML parserHTML;



    public void parseHtmlPage(String url,String country) {
        parserHTML.parserHtmlPage(url,country);
    }
}
