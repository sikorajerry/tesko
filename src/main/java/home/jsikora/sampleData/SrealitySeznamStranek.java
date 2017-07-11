package home.jsikora.sampleData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungsam on 26.6.17.
 */
@Component
public class SrealitySeznamStranek {
    private static final Logger log = LoggerFactory.getLogger(SrealitySeznamStranek.class);
    private List<String> listPages = new ArrayList<>();
    private List<String> pagesGenerator = new ArrayList<>();
    private WebDriver driver ;
    private String sreality = "https://www.sreality.cz/hledani/prodej/byty/praha";
    final int pocetStranek = 262;

    @PostConstruct
    public void initialize() {
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");



        pagesGenerator.add(sreality);

        for(int page=2; page < pocetStranek; page++){
            //do listu nastavuju hlavni stranky po pages
            pagesGenerator.add(sreality+"?strana="+page);
        }


        int i = 0 ;
        for(String url:pagesGenerator) {
            i++;
            driver = new FirefoxDriver();

            // launch Fire fox and direct it to the Base URL
            driver.get(url);

            List<WebElement> webElementHlavniSeznam = driver.findElements(By.className("title"));

            log.info("Projit jeste  " + (pocetStranek - i));

            for (WebElement webElement : webElementHlavniSeznam) {
                if (webElement.getTagName().equals("a")) {
                    //vyhledam vsechny odkazy na hlavnich strankach a ulozit do listPages
                    listPages.add(webElement.getAttribute("href"));
                }

            }
            driver.close();


        }



    }


    public List<String> getListPages() {
        return listPages;
    }
}

