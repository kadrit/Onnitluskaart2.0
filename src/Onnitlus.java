//see on klass kasutaja sisestatud andmete hoidmiseks, muutujad väärtustatakse klassis Graafiline
public class Onnitlus {
    String nimi;
    String vanus;
    String kolleegSober;
    String sugu;
    String onnitleja;

    public Onnitlus(String nimi, String vanus, String kolleegSober, String sugu, String onnitleja) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.kolleegSober = kolleegSober;
        this.sugu = sugu;
        this.onnitleja = onnitleja;

    }

    public String getNimi() {
        return nimi;
    }

    public String getVanus() {
        return vanus;
    }

    public String getKolleegSober() {
        return kolleegSober;
    }

    public String getSugu() {
        return sugu;
    }

    public String getOnnitleja() {
        return onnitleja;
    }



}


