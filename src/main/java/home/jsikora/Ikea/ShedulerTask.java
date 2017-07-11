package home.jsikora.Ikea;


import home.jsikora.sampleData.BezrealitkySeznamStranek;
import home.jsikora.service.ServiceBezrealitky;
import home.jsikora.service.ServiceSreality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sungsam on 23.5.17.
 */
@Component
public class ShedulerTask {
    private static final Logger log = LoggerFactory.getLogger(ShedulerTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private ServiceSreality serviceSreality;

    @Autowired
    private ServiceBezrealitky serviceBezrealitky;




    @Scheduled(fixedRate = 1000 * 60 * 60)
    public void reportCurrentTime() throws Exception {
        log.info("The time is now {}", dateFormat.format(new Date()));
        serviceSreality.parseHtmlPages();

    }


 /*   @Scheduled(fixedRate = 1000 * 60 * 60)
    public void spustBezRealitky() throws Exception {
        log.info("The time is now {}", dateFormat.format(new Date()));
        serviceBezrealitky.parseHtmlPages();

    }
    */

}
