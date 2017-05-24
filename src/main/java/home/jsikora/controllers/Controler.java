package home.jsikora.controllers;

import home.jsikora.parser.ParserHTML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by sungsam on 23.5.17.
 */
@Controller
public class Controler {

    @Autowired
    ParserHTML parserHTML;

    public void parseHtmlPage(String url,String country) {

    }
}
