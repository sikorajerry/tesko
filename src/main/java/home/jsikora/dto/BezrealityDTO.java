package home.jsikora.dto;

import javax.persistence.*;

/**
 * Created by sungsam on 3.7.17.
 */
@Entity
@Table(name = "bezrealitka")
public class BezrealityDTO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String inzeratId;
    private String nemovitost;
    private String dispozice;
    private int plocha;
    private long cena;
    private String vlastnictvi;
    private boolean balkon;
    private boolean terasa;
    private String adresa;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInzeratId() {
        return inzeratId;
    }

    public void setInzeratId(String inzeratId) {
        this.inzeratId = inzeratId;
    }

    public String getNemovitost() {
        return nemovitost;
    }

    public void setNemovitost(String nemovitost) {
        this.nemovitost = nemovitost;
    }

    public String getDispozice() {
        return dispozice;
    }

    public void setDispozice(String dispozice) {
        this.dispozice = dispozice;
    }

    public int getPlocha() {
        return plocha;
    }

    public void setPlocha(int plocha) {
        this.plocha = plocha;
    }

    public long getCena() {
        return cena;
    }

    public void setCena(long cena) {
        this.cena = cena;
    }

    public String getVlastnictvi() {
        return vlastnictvi;
    }

    public void setVlastnictvi(String vlastnictvi) {
        this.vlastnictvi = vlastnictvi;
    }

    public boolean isBalkon() {
        return balkon;
    }

    public void setBalkon(boolean balkon) {
        this.balkon = balkon;
    }


    public boolean isTerasa() {
        return terasa;
    }

    public void setTerasa(boolean terasa) {
        this.terasa = terasa;
    }



    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "BezrealityDTO{" +
                "inzeratId='" + inzeratId + '\'' +
                ", nemovitost='" + nemovitost + '\'' +
                ", dispozice='" + dispozice + '\'' +
                ", plocha=" + plocha +
                ", cena=" + cena +
                ", vlastnictvi='" + vlastnictvi + '\'' +
                ", balkon=" + balkon +
                ", terasa=" + terasa +
                ", adresa='" + adresa + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
