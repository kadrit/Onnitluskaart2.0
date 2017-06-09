// see klass on luuletuse faili salvestamiseks

import java.io.*;

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

            } catch (IOException e) {
                System.out.println("Kirjutamine ei õnnestunud! Proovi programmi uuesti!");
                System.exit(1);
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

