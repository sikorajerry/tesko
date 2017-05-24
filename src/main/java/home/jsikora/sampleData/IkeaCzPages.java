package home.jsikora.sampleData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sungsam on 23.5.17.
 */
@Component
public class IkeaCzPages {

    private static final Logger log = LoggerFactory.getLogger(IkeaCzPages.class);
    private List<String> listPages = new ArrayList<>();

    @PostConstruct
    public void initialize() {

        for (int i = 0; i < 25; i++) {
            log.info("jsem zde http://www.ikea.com/cz/cs/catalog/productsaz/"+ i +"/");
            listPages.add("http://www.ikea.com/cz/cs/catalog/productsaz/"+ i +"/");
        }
    }

    public List<String> getListPages() {
        return listPages;
    }
}
