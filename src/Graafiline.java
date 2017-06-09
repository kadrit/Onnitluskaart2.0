


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    }


    @Override
    public void start(Stage primaryStage)  {
        BorderPane piiriPaan = new BorderPane();
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20, 20, 20, 20));
        //hbox.setSpacing(10); //vahe kahe nupu vahel
        hbox.setStyle("-fx-background-color: #336699;");
        Text tekst = new Text ("Õnnitluskaart");
        tekst.setFont(Font.font("Gambria", 35));
        tekst.setFill(Color.SNOW);
        hbox.alignmentProperty().setValue(Pos.CENTER);
        hbox.getChildren().add(tekst);


        GridPane grid = new GridPane();

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 150, 10, 10));
        grid2.setVgap(5);
        grid2.setHgap(5);

        piiriPaan.setTop(hbox); //Sinine kast pealkirja jaoks
        piiriPaan.setLeft(grid); // Kasutajalt sisendi saamise väljade kast
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
        final ChoiceBox <String> taiskasvanuvoilaps= new ChoiceBox();
        taiskasvanuvoilaps.setItems(FXCollections.observableArrayList(
                "laps",
                "täiskasvanu"
        ));

        taiskasvanuvoilaps.getSelectionModel().selectFirst();
        GridPane.setConstraints(taiskasvanuvoilaps, 0, 6);
        grid.getChildren().add(taiskasvanuvoilaps);


        final Label vanusekast = new Label();
        GridPane.setConstraints(vanusekast, 0, 5);
        GridPane.setColumnSpan(vanusekast, 1);
        vanusekast.setText("Laps või täiskasvanu?");
        grid.getChildren().add(vanusekast);

        //Kolleeg/sõber

        final ChoiceBox <String> kolleeg= new ChoiceBox();
        kolleeg.setItems(FXCollections.observableArrayList(
                "sõber",
                "kolleeg"
        ));
        kolleeg.getSelectionModel().selectFirst();

        GridPane.setConstraints(kolleeg, 0, 8);
        grid.getChildren().add(kolleeg);

        final Label seosekast = new Label();
        GridPane.setConstraints(seosekast, 0, 7);
        GridPane.setColumnSpan(seosekast, 1);
        seosekast.setText("Sõber või kolleeg?");
        grid.getChildren().add(seosekast);

        //Naine/mees
        final Label sookast = new Label();
        GridPane.setConstraints(sookast, 0, 9);
        GridPane.setColumnSpan(sookast, 1);
        sookast.setText("Naine või mees?");
        grid.getChildren().add(sookast);


        //Naine või mees
        final ChoiceBox <String> meesvoinaine= new ChoiceBox();
        meesvoinaine.setItems(FXCollections.observableArrayList(
                "mees",
                "naine"
        ));
        meesvoinaine.getSelectionModel().selectFirst();
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

                String vanus = taiskasvanuvoilaps.getValue().toString();
                String kolleegSober = kolleeg.getValue().toString();
                if (vanus.equals("laps")) {         //kui laps, siis on sõber.
                    kolleegSober = "sõber";
                }
                String sugu = meesvoinaine.getValue().toString();


                if(onnitleja.isEmpty() || nimi.isEmpty() ){
                    label.setText("Sa ei sisestanud kõiki andmeid!");
                } else{


                    //selliselt saab kätte ühe sisestuse parameetrid
                    Onnitlus onnitlus1 = new Onnitlus(nimi, vanus, kolleegSober, sugu, onnitleja);


                    try {
                        Onnitlused.salvestaLuuletus("katse.txt", onnitlus1);  //loeb failist kõik read sisse.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String luuletus = Onnitlused.leiasobivLuuletus(onnitlus1); // leiab sobivate seast juhusliku luuletuse

                    //väli pöördumiseks
                    String pöördumine = new String();
                    if (kolleegSober.equals("sõber")) {
                        pöördumine = "Kallis ";
                    } else {
                        pöördumine = "Hea ";
                    }
                    final Label onnitletav = new Label();
                    GridPane.setConstraints(onnitletav, 2, 10);
                    GridPane.setColumnSpan(onnitletav, 2);
                    onnitletav.setText(pöördumine + onnitlus1.getNimi() + "!");
                    onnitletav.setFont(Font.font("Gambria", 12));
                    grid2.getChildren().add(onnitletav);


                    //väli luuletuse ekraanile kuvamise jaoks
                    final Label luuletusekoht = new Label();
                    GridPane.setConstraints(luuletusekoht, 2, 11);
                    GridPane.setColumnSpan(luuletusekoht, 2);
                    luuletusekoht.setText(luuletus.replace("/", "\n"));
                    luuletusekoht.setFont(Font.font("Gambria", 12));
                    grid2.getChildren().add(luuletusekoht);

                    //väli lõpetuseks
                    final Label lopetus = new Label();
                    GridPane.setConstraints(lopetus, 2, 11 + Onnitlused.luuletusePikkus(onnitlus1));
                    GridPane.setColumnSpan(lopetus, 2);
                    lopetus.setText("Palju õnne!" + "\n" + onnitlus1.getOnnitleja());
                    lopetus.setFont(Font.font("Gambria", 12));
                    grid2.getChildren().add(lopetus);


//Luuletuse faili saatmise nupp
                    final Button toFail = new Button("Saada luuletus faili");
                    GridPane.setConstraints(toFail, 2, 30);
                    grid2.getChildren().add(toFail);

                    toFail.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            FailiSalvestamine.salvestaFaili(luuletus.replace("/", "\n")); //replace selleks, et failis oleks ka iga rida omal real
                        }});

// sisestajale aitäh ütlemise koht


                    label.setText(onnitlus1.getOnnitleja() + ", "
                            + "aitäh, et kasutasid meie luuletusevalijat!");
                }
                }
        });

//määrab, mida teeb nupp Puhasta
        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                name.clear();
                //taiskasvanuvoilaps.clear();
                //taiskasvanuvoilaps.getItems().clear();
               // taiskasvanuvoilaps.setItems(FXCollections.observableArrayList(
                 //       "laps",
                //        "täiskasvanu"
               // ));
                //kolleeg.setItems(FXCollections.observableArrayList(
               //         "kolleeg",
              //          "sõber"
               // ));
              //  meesvoinaine.setItems(FXCollections.observableArrayList(
               //         "mees",
             //           "naine"
               //hf ));

                //kolleeg.clear();
                //meesvoinaine.clear();
                onnitlejad.clear();
                label.setText(null);

            }});

        //väli programmi tutvustava teksti jaoks
        final Label labelsissejuhatus = new Label();
        GridPane.setConstraints(labelsissejuhatus, 0, 0);
        GridPane.setColumnSpan(labelsissejuhatus, 2);
        labelsissejuhatus.setText("Programm aitab õnnitluskaarti koostada, pakkudes sobivaid luuletusi.\nVali, kas õnnitletav on laps või täiskasvanu, sõber või kolleeg, mees või naine.\nLuuletus valitakse sisestatud parameetritele vastavate luuletuste seast.");
        labelsissejuhatus.setFont(Font.font("Gambria", 12));
        grid.getChildren().add(labelsissejuhatus);



//aknale nimepanemine
        Scene stseen = new Scene(piiriPaan, 1000, 700, Color.BLANCHEDALMOND); //BorderPane ehk juur on asetatud stseeni
        primaryStage.setTitle("Õnnitluskaardi rakendus");
        primaryStage.setScene(stseen); //stseen lavale
        primaryStage.show();

    }

}