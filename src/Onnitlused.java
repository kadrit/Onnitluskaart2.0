import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

//see on klass failist luuletuste sisselugemiseks. Praegu paneb kõik read failist Onnitlused isendisse onnitlused

public class Onnitlused {

    String failistvanus; //väärtused võivad olla laps või täiskasvanu
    String failistkolleegSober; // väärtused võivad olla kolleeg või sõber
    String failistsugu; //väärtused võivad olla mees või naine
    String failistluuletus; //muutuja luuletuse hoidmiseks

    @Override
    public String toString() {
        return "Onnitlused{" +
                "failistvanus='" + failistvanus + '\'' +
                ", failistkolleegSober='" + failistkolleegSober + '\'' +
                ", failistsugu='" + failistsugu + '\'' +
                ", failistluuletus='" + failistluuletus + '\'' +
                '}';
    }

    public Onnitlused(String failistvanus, String failistkolleegSober, String failistsugu, String failistluuletus) {
        this.failistvanus = failistvanus;
        this.failistkolleegSober = failistkolleegSober;
        this.failistsugu = failistsugu;
        this.failistluuletus = failistluuletus;
    }

    static ArrayList<Onnitlused> list = new ArrayList<>(); //list failist sisse loetud onnitluste isendite hoidmiseks

    public static void salvestaLuuletus(String failinimi) throws Exception {
        BufferedReader loetudRead = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi), "UTF-8"));
        String rida;
        String[] reaTükid;

        while ((rida = loetudRead.readLine()) != null) {
            reaTükid = rida.split(";");

            Onnitlused onnitlused = new Onnitlused(reaTükid[0], reaTükid[1], reaTükid[2], reaTükid[3]);

            list.add(onnitlused);
            System.out.println(onnitlused);
        }
    }

    //siia peaks tulema meetod mis valib juhusliku Onnitlus isendile sobivad luuletuse Onnitluste listist.
    public void leiasobivLuuletus() {

    }

}