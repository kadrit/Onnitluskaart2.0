import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FailiSalvestamine {
    public static void salvestaFaili(String string){
        BufferedWriter bw = null;
            try {
                File file = new File("luuletus.txt");

	            if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(string);
                System.out.println("Luuletus on kirjutatud faili luuletus.txt");

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            finally
            {
                try{
                    if(bw!=null)
                        bw.close();
                }catch(Exception ex){
                    System.out.println("Viga bufferedwriteri sulgemisel"+ex);
                }
            }
        }
    }

