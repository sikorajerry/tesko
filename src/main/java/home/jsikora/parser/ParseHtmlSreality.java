package home.jsikora.parser;

import home.jsikora.dto.SrealityDTO;
import home.jsikora.repository.SRealityRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sungsam on 26.6.17.
 */
@Component
public class ParseHtmlSreality {

    @Autowired
    private SRealityRepository sRealityRepository;

    private static final Logger log = LoggerFactory.getLogger(ParseHtmlSreality.class);

    public void parseSrealityPage(String baseUrl, WebDriver driver) throws Exception {


        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        Map<String, String> rightHereMap = new HashMap<String, String>();
        List<WebElement> webElementTabulkaValue = driver.findElements(By.className("param-value"));
        List<WebElement> webElementTabulkaName = driver.findElements(By.className("param-label"));

        log.info("-----------------------------------------------------------------");
        WebElement webElementCena = driver.findElement(By.className("norm-price"));
        rightHereMap.put("Cena",webElementCena.getText());

        WebElement webElementLocation = driver.findElement(By.className("location-text"));
        rightHereMap.put("Location", webElementLocation.getText());

        rightHereMap.put("Odkaz", baseUrl);

        for (int i=0; i<webElementTabulkaValue.size(); i++) {
            rightHereMap.put(webElementTabulkaName.get(i).getText(), webElementTabulkaValue.get(i).getText());
        }

        saveHashMapToDatabase(rightHereMap);
        //vypis mapy

    }

    private void saveHashMapToDatabase(Map<String, String> mapa) {

        SrealityDTO srealityDTO = new SrealityDTO();
        srealityDTO.setZakazkaID(mapa.get("ID zakázky"));
        srealityDTO.setStavba(mapa.get("Stavba"));
        srealityDTO.setOdkaz(mapa.get("Odkaz"));
        srealityDTO.setVlastnictvi(mapa.get("Vlastnictví"));
        srealityDTO.setLocation(mapa.get("Location"));



        String uzitnaPlocha = mapa.get("Užitná plocha:");
        if (uzitnaPlocha != null) {
            uzitnaPlocha = uzitnaPlocha.substring(0, uzitnaPlocha.length() - 2);
            srealityDTO.setUzitnaPlocha(Double.parseDouble(uzitnaPlocha));
        }

        String sklep = mapa.get("Sklep:");
        if (sklep != null && sklep.length()>0) {
            sklep = sklep.substring(0,sklep.length()-3);
            srealityDTO.setSklep(Integer.parseInt(sklep));
        } else {
            log.warn("sklep neuvedeny");
        }

      String cena = mapa.get("Cena");
        if (cena != null && !cena.equals("Info o ceně u RK")) {
            cena = cena.substring(0,cena.length()-2).replaceAll("\\s","");
            srealityDTO.setCena(Long.parseLong(cena));
        } else {
            log.info("Cena neni zadana nebo Info o ceně u RK");
        }

      String zakazka = mapa.get("ID zakázky:");
        if (zakazka != null) {
            srealityDTO.setZakazkaID(zakazka);
        } else {
            zakazka = mapa.get("ID:");
            srealityDTO.setZakazkaID(zakazka);
            this.printMapToLog(mapa);
        }



        String vlastnictvni = mapa.get("Vlastnictví:");
        if (vlastnictvni != null) {
            srealityDTO.setVlastnictvi(vlastnictvni);
        } else {
            log.info("Vlastnictvni neexistuje");
        }

        sRealityRepository.save(srealityDTO);
        log.info(srealityDTO.toString());
       // this.printMapToLog(mapa);
    }

    private void printMapToLog(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            log.info(entry.getKey()+" : "+entry.getValue());
        }
    }
}
