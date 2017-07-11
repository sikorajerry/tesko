package home.jsikora.service;

import home.jsikora.parser.ParseHtmlBezreality;
import home.jsikora.repository.BezRealitkyRepository;
import home.jsikora.sampleData.BezrealitkySeznamStranek;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by sungsam on 2.7.17.
 */
@Service
public class ServiceBezrealitky {
    private static final Logger log = LoggerFactory.getLogger(ServiceBezrealitky.class);

    @Autowired
    private ParseHtmlBezreality parseHtmlBezreality;

    @Autowired
    private BezrealitkySeznamStranek bezrealitkySeznamStranek;

    @Autowired
    private BezRealitkyRepository bezRealitkyRepository;

    public void parseHtmlPages() {

        for(String url: bezrealitkySeznamStranek.getListPages()) {
            try {
              //https://www.bezrealitky.cz/id/398098
                int index = url.indexOf("id");
                String checkDb = url.substring(index+3);
                    log.info(checkDb + "  je v db " +bezRealitkyRepository.findByInzeratId(checkDb) );
                if (bezRealitkyRepository.findByInzeratId(checkDb)==null) {
                    parseHtmlBezreality.parsePage(url);
                } else {
                    log.info("Record "+checkDb+" exist in db");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
