package home.jsikora.dto;

import javax.persistence.*;

/**
 * Created by sungsam on 27.6.17.
 */
@Entity
@Table(name = "sreality")
public class SrealityDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String zakazkaID;

    private String odkaz;

    private double uzitnaPlocha;

    private String vlastnictvi;

    private String stavba;

    private int sklep;

    private String location;

    private Long cena;

    public String getZakazkaID() {
        return zakazkaID;
    }

    public void setZakazkaID(String zakazkaID) {
        this.zakazkaID = zakazkaID;
    }

    public String getOdkaz() {
        return odkaz;
    }

    public void setOdkaz(String odkaz) {
        this.odkaz = odkaz;
    }

    public double getUzitnaPlocha() {
        return uzitnaPlocha;
    }

    public void setUzitnaPlocha(double uzitnaPlocha) {
        this.uzitnaPlocha = uzitnaPlocha;
    }

    public String getVlastnictvi() {
        return vlastnictvi;
    }

    public void setVlastnictvi(String vlastnictvi) {
        this.vlastnictvi = vlastnictvi;
    }

    public String getStavba() {
        return stavba;
    }

    public void setStavba(String stavba) {
        this.stavba = stavba;
    }

    public int getSklep() {
        return sklep;
    }

    public void setSklep(int sklep) {
        this.sklep = sklep;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getCena() {
        return cena;
    }

    public void setCena(Long cena) {
        this.cena = cena;
    }

    public SrealityDTO() {}

    public SrealityDTO(String zakazkaID, String odkaz, double uzitnaPlocha, String vlastnictvi, String stavba, int sklep, String location, Long cena) {
        this.zakazkaID = zakazkaID;
        this.odkaz = odkaz;
        this.uzitnaPlocha = uzitnaPlocha;
        this.vlastnictvi = vlastnictvi;
        this.stavba = stavba;
        this.sklep = sklep;
        this.location = location;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "SrealityDTO{" +
                "id=" + id +
                ", zakazkaID='" + zakazkaID + '\'' +
                ", odkaz='" + odkaz + '\'' +
                ", uzitnaPlocha=" + uzitnaPlocha +
                ", vlastnictvi='" + vlastnictvi + '\'' +
                ", stavba='" + stavba + '\'' +
                ", sklep=" + sklep +
                ", location='" + location + '\'' +
                ", cena=" + cena +
                '}';
    }
}
