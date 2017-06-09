import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

//see on klass failist luuletuste sisselugemiseks. Klassi Onnitlused isendisse onnitlused pannakse ainult need read,
//mis vastavad kasutaja sisestatud tingimustele.

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

    static ArrayList<Onnitlused> list = new ArrayList<>(); //list failist sisse loetud onnitluste isendite hoidmiseks, mis vastavad kasutajate tingimustele

    public static void salvestaLuuletus(String failinimi, Onnitlus onnitlus1) throws Exception {
        BufferedReader loetudRead = new BufferedReader(new InputStreamReader(new FileInputStream(failinimi), "UTF-8"));
        String rida;
        String[] reaTükid;

        while ((rida = loetudRead.readLine()) != null) {
            reaTükid = rida.split(";");

            Onnitlused onnitlused = new Onnitlused(reaTükid[0], reaTükid[1], reaTükid[2], reaTükid[3]);
            if (onnitlused.failistvanus.equals(onnitlus1.getVanus()) && onnitlused.failistkolleegSober.equals(onnitlus1.getKolleegSober()) && onnitlused.failistsugu.equals(onnitlus1.getSugu())) {
                list.add(onnitlused);
            }
            //System.out.println(onnitlused);
        }
        //System.out.println(list);
        loetudRead.close();
    }

    // meetod, mis valib juhusliku Onnitlus isendile sobivad luuletuse Onnitluste listist.
    public static String leiasobivLuuletus(Onnitlus onnitlus1) {
        //Juhusliku arvu leidmine, mille alusel valitakse luuletuste listist välja juhuslik luuletus
        Random r = new Random();
        int a = r.nextInt(list.size());
        //Juhusliku luuletuse leidmine juhuslikku arvu kasutades:
        Onnitlused valitudLuuletuseKirje = list.get(a);
        String valitudLuuletus = valitudLuuletuseKirje.failistluuletus;
        return valitudLuuletus;
    }

    //luuletuse pikkuse(ridades) leidmine, et saaks õnnitluse luuletuse alla kirjutada õigesse kohta
    public static int luuletusePikkus(Onnitlus onnitlus1) {
        String[] luuleread = leiasobivLuuletus(onnitlus1).split("/");
        int pikkus = 0;
        for (int i = 0; i < luuleread.length; i++) {
        }
        pikkus += 1;
        return pikkus;
    }
}