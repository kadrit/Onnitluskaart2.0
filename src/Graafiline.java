

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Graafiline extends Application {


    public static void main(String[] args)  throws Exception{
        launch(args);

        Onnitlused.salvestaLuuletus("katse.txt");  //katsetamiseks, kas loeb failist kõik read sisse. Loeb, teeb hunniku isendeid konstruktoriga klassist Onnitlused
        // hakkab tööle alles pärast seda kui aken on kinni pandud
    }

    @Override
    public void start(Stage primaryStage)  {
        BorderPane piiriPaan = new BorderPane();
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20, 20, 20, 20)); //vahe HBoxi servadest
        //hbox.setSpacing(10); //vahe kahe nupu vahel
        hbox.setStyle("-fx-background-color: #336699;");
        Text tekst = new Text ("Õnnitluskaart");
        tekst.setFont(Font.font("Gambria", 35));
        tekst.setFill(Color.SNOW);
        hbox.alignmentProperty().setValue(Pos.CENTER); //Hboxil olev tekst paigutatakse keskele
        hbox.getChildren().add(tekst);


        GridPane grid = new GridPane();

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 150, 10, 10));
        grid2.setVgap(5);
        grid2.setHgap(5);

        piiriPaan.setTop(hbox); //Sinine kast pealkirja jaoks
        piiriPaan.setLeft(grid); // Kasutajalt sisendi saamise kast
        piiriPaan.setRight(grid2); //koht luuletuse väljatrükkimiseks

//loob konteineri
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

//tekstiväljade defineerimised:
        final TextField name = new TextField();
        name.setPromptText("nimi"); //sisestamise kasti põhjas näidatav tekst
        GridPane.setConstraints(name, 0, 4);
        grid.getChildren().add(name);


        final Label nimekast = new Label();
        GridPane.setConstraints(nimekast, 0, 3);
        GridPane.setColumnSpan(nimekast, 2);
        nimekast.setText("Mis on sünnipäevalapse nimi?");
        grid.getChildren().add(nimekast);


        //Laps/täiskasvanu
        TextField taiskasvanuvoilaps = new TextField();
        taiskasvanuvoilaps.setPromptText("laps või täiskasvanu");
        GridPane.setConstraints(taiskasvanuvoilaps, 0, 6);
        grid.getChildren().add(taiskasvanuvoilaps);


        final Label vanusekast = new Label();
        GridPane.setConstraints(vanusekast, 0, 5);
        GridPane.setColumnSpan(vanusekast, 1);
        vanusekast.setText("Laps või täiskasvanu?");
        grid.getChildren().add(vanusekast);

        //Kolleeg/sõber
        final TextField kolleeg = new TextField();
        kolleeg.setPromptText("sõber või kolleeg");
        GridPane.setConstraints(kolleeg, 0, 8);
        grid.getChildren().add(kolleeg);

        final Label seosekast = new Label();
        GridPane.setConstraints(seosekast, 0, 7);
        GridPane.setColumnSpan(seosekast, 1);
        seosekast.setText("Kas sõber või kolleeg?");
        grid.getChildren().add(seosekast);

        //Naine/mees
        final Label sookast = new Label();
        GridPane.setConstraints(sookast, 0, 9);
        GridPane.setColumnSpan(sookast, 1);
        sookast.setText("Naine või mees?");
        grid.getChildren().add(sookast);


        //Naine või mees
        final TextField meesvoinaine = new TextField();
        meesvoinaine.setPromptText("naine või mees");
        GridPane.setConstraints(meesvoinaine, 0, 10);
        grid.getChildren().add(meesvoinaine);


        //Õnnitleja ehk andmete sisestaja
        final TextField onnitlejad = new TextField();
        onnitlejad.setPromptText("Sinu nimi");
        GridPane.setConstraints(onnitlejad, 0, 12);
        grid.getChildren().add(onnitlejad);


        final Label onnitlejakast = new Label();
        GridPane.setConstraints(onnitlejakast, 0, 11);
        GridPane.setColumnSpan(onnitlejakast, 1);
        onnitlejakast.setText("Kes õnnitleb?");
        grid.getChildren().add(onnitlejakast);


//Andmete sisestamise nupp
        final Button submit = new Button("Saada");
        GridPane.setConstraints(submit, 1, 4);
        grid.getChildren().add(submit);

//Väljade puhastamise nupp
        Button clear = new Button("Puhasta");
        GridPane.setConstraints(clear, 1, 5);
        grid.getChildren().add(clear);

//lisab välja, kus saab sisestajale aitäh öelda
        final Label label = new Label();
        GridPane.setConstraints(label, 0, 13);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        //paneb kasutaja sisestatud andmed muutujatesse
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String onnitleja = String.valueOf(onnitlejad.getText());
                String nimi = String.valueOf(name.getText());
                String vanus = String.valueOf(taiskasvanuvoilaps.getText());
                String kolleegSober = String.valueOf(kolleeg.getText());
                String sugu = String.valueOf(meesvoinaine.getText());


//selliselt saab kätte küll ühe sisestuse parameetrid, aga kuidas seda kasutada väljaspool seda klassi ja isegi väljaspool seda meetodit?
                Onnitlus onnitlus = new Onnitlus (nimi, vanus, kolleegSober, sugu, onnitleja);
                System.out.println(onnitlus); //katsetamiseks, kas muutujad on väärtustatud
                if (
                        (nimi != null && !nimi.isEmpty())  //siia saab erindi teha?
                        ) {
                    label.setText(onnitlejad.getText() + ", "
                            + "Aitäh!");
                } else {
                    label.setText("Sa ei sisestanud midagi!");
                }

            }
        });

//määrab, mida teeb nupp Puhasta
        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                name.clear();
                taiskasvanuvoilaps.clear();
                kolleeg.clear();
                meesvoinaine.clear();
                onnitlejad.clear();
                label.setText(null);
            }});

        //väli programmi tutvustava teksti jaoks
        final Label labelsissejuhatus = new Label();
        GridPane.setConstraints(labelsissejuhatus, 0, 0);
        GridPane.setColumnSpan(labelsissejuhatus, 2);
        labelsissejuhatus.setText("Programm on mõeldud selleks, et aidata õnnitluskaarti koostada.\nKasutaja saab valida, kas õnnitletav on laps/täiskasvanu, sõber/kolleeg, mees/naine.\nLuuletus valitakse juhuslikult sisestatud parameetritele vastavate luuletuste seast");
        labelsissejuhatus.setFont(Font.font("Gambria", 12));
        grid.getChildren().add(labelsissejuhatus);

//väli luuletuse ekraanile kuvamise jaoks
        final Label luuletusekoht = new Label();
        GridPane.setConstraints(luuletusekoht, 2, 10);
        GridPane.setColumnSpan(luuletusekoht, 2);
        luuletusekoht.setText("Siia tuleb luuletus");
        luuletusekoht.setFont(Font.font("Gambria", 12));
        grid2.getChildren().add(luuletusekoht);

//aknale nimepanemine
        Scene stseen = new Scene(piiriPaan, 1000, 700, Color.BLANCHEDALMOND); //BorderPane ehk juur on asetatud stseeni
        primaryStage.setTitle("Õnnitluskaardi rakendus");
        primaryStage.setScene(stseen); //stseen lavale
        primaryStage.show();

    }

}