package home.jsikora.Ikea;


import home.jsikora.sampleData.IkeaCzPages;
import home.jsikora.service.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by sungsam on 23.5.17.
 */
@Component
public class ShedulerTask {
    private static final Logger log = LoggerFactory.getLogger(ShedulerTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private Services  services;

    @Autowired
    private IkeaCzPages ikeaCzPages;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        for (String page: ikeaCzPages.getListPages()) {
            services.parseHtmlPage(page);
        }


    }


}
