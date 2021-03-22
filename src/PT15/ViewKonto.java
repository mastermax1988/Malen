package PT15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewKonto{
    public TextField txtKonto;
    public Label lblKonto;
    public Button btnEinzahlen;
    public Button btnAuszahlen;

    private Konto model;
    private Stage stage;

    public Alert alertDeckung, alertPositiv, alertBetrag;

    public ViewKonto(Konto model, Stage primaryStage) throws IOException {
        this.model = model;
        this.stage = primaryStage;
        alertBetrag = new Alert(Alert.AlertType.INFORMATION,"Sie müssen einen Betrag eingeben!", ButtonType.OK);
        alertDeckung = new Alert(Alert.AlertType.ERROR,"Ihr Konto weist keine ausreichende Deckung auf!", ButtonType.OK);
        alertPositiv = new Alert(Alert.AlertType.INFORMATION,"Geben Sie einen positiven Betrag ein!", ButtonType.OK);
        alertBetrag.initStyle(StageStyle.UTILITY);
        alertDeckung.initStyle(StageStyle.UTILITY);
        alertPositiv.initStyle(StageStyle.UTILITY);
        Pane root = FXMLLoader.load(getClass().getResource("/ViewKontoFxml.fxml"));
        Scene scene = new Scene(root);
        lblKonto = (Label) scene.lookup("#lblKonto");
        txtKonto = (TextField) scene.lookup("#txtKonto");
        btnEinzahlen = (Button) scene.lookup("#btnEinzahlen");
        btnAuszahlen = (Button) scene.lookup("#btnAuszahlen");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }


}
