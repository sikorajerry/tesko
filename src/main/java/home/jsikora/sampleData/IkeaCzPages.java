package home.jsikora.sampleData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sungsam on 23.5.17.
 */
@Component
public class IkeaCzPages {

    private static final Logger log = LoggerFactory.getLogger(IkeaCzPages.class);
    private List<String> listPages;

    @PostConstruct
    public void initialize() {
        String[] array = new String[] { "http://www.ikea.com/cz/cs/catalog/productsaz/0/", "http://www.ikea.com/cz/cs/catalog/productsaz/1/" };
       listPages = Arrays.asList(array);
    }

    public List<String> getListPages() {
        return listPages;
    }
}
