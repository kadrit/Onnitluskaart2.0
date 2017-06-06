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




    @Override
    public String toString() {
        return "Õnnitlus " +
                "nimi= " + nimi + '\'' +
                ", vanus= " + vanus + '\'' +
                ", kolleegSober= " + kolleegSober + '\'' +
                ", sugu= " + sugu + '\'' +
                ", onnitleja " + onnitleja + '\'';


    }

}


