package PT15;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainBank extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Konto konto = new Konto();
        konto.setStand(100);
        ViewKonto viewKonto = new ViewKonto(konto, primaryStage);

        ControllerBank controllerBank = new ControllerBank(viewKonto, konto);
    }
}
