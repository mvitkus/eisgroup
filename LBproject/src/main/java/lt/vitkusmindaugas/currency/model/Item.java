package lt.vitkusmindaugas.currency.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pavadinimas;
    private String valiutos_kodas;
    private String santykis;
    private String data;

    public Item() {
    }

    public Item(String pavadinimas, String valiutos_kodas, String santykis, String data) {
        this.pavadinimas = pavadinimas;
        this.valiutos_kodas = valiutos_kodas;
        this.santykis = santykis;
        this.data = data;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getValiutos_kodas() {
        return valiutos_kodas;
    }

    public void setValiutos_kodas(String valiutos_kodas) {
        this.valiutos_kodas = valiutos_kodas;
    }

    public String getSantykis() {
        return santykis;
    }

    public void setSantykis(String santykis) {
        this.santykis = santykis;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
