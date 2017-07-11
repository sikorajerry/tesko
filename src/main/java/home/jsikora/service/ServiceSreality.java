package home.jsikora.service;

import home.jsikora.dto.SrealityDTO;
import home.jsikora.parser.ParseHtmlSreality;
import home.jsikora.repository.SRealityRepository;
import home.jsikora.sampleData.SrealitySeznamStranek;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sungsam on 26.6.17.
 */
@Service
public class ServiceSreality {

    private static final Logger log = LoggerFactory.getLogger(ServiceSreality.class);
    List<String> nepodareneParsovaneURL = new ArrayList<>();

    @Autowired
    private ParseHtmlSreality parseHtmlSreality;

    @Autowired
    private SrealitySeznamStranek srealitySeznamStranek;

    @Autowired
    private SRealityRepository sRealityRepository;




    public void parseHtmlPages() {

        WebDriver driver ;
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        driver = new FirefoxDriver();



        for(String url: srealitySeznamStranek.getListPages()) {


            SrealityDTO srealityDTO = sRealityRepository.findByOdkaz(url);
            //pokud odkaz neni v databazi
            if (srealityDTO == null) {


                try {
                    parseHtmlSreality.parseSrealityPage(url, driver);
                } catch (Exception e) {
                    log.error("Nemuzu naparsovat " + url);
                    nepodareneParsovaneURL.add(url);
                    e.printStackTrace();
                }

            } else {
                log.warn("Tento zaznam uz je v databazi "+ url);
            }
        }

        for (String nezdar : nepodareneParsovaneURL) {
            log.error("Stranky nebyly nacteny "+ nezdar);
        }

        driver.close();

        this.parseHtmlPagesAgain(nepodareneParsovaneURL);

    }

    public void parseHtmlPagesAgain(List<String> urls) {
        WebDriver driver ;
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        for(String url: urls) {

            SrealityDTO srealityDTO = sRealityRepository.findByOdkaz(url);
            //pokud odkaz neni v databazi
            if (srealityDTO == null) {


                try {
                    parseHtmlSreality.parseSrealityPage(url, driver);
                } catch (Exception e) {
                    log.error("Nemuzu naparsovat 2 kolo" + url);
                    e.printStackTrace();
                }

            } else {
                log.warn("Tento zaznam uz je v databazi 2 kolo "+ url);
            }
        }
        driver.close();
    }
}
