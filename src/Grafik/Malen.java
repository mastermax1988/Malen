package Grafik;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class Malen extends Application
{
    Color farbe;

    private static Map<String, Color> zuordnung;

    @Override
    public void start(Stage stage) throws Exception
    {
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: GRAY;");
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        pane.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseEvent -> {
            addCircle(pane, mouseEvent,mouseEvent.isPrimaryButtonDown()?5:0);
        });
        pane.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent ->
        {
            addCircle(pane, mouseEvent, mouseEvent.isSecondaryButtonDown()?10:mouseEvent.isPrimaryButtonDown()?5:0);
        });
        GridPane menuPane = new GridPane();
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(zuordnung.keySet());
        comboBox.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                farbe = zuordnung.get(comboBox.getValue());
            }
        });

        //comboBox.setValue("rot");
        //farbe = Color.RED;
        menuPane.add(comboBox,0,0);
        Button button = new Button();
        button.setText("Alles löschen");
        button.addEventHandler(ActionEvent.ACTION, e -> {
            pane.getChildren().clear();
        });
        menuPane.add(button,1,0);
        borderPane.setBottom(menuPane);
        Scene scene = new Scene(borderPane,800,600);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    private void addCircle(Pane pane, MouseEvent mouseEvent, int r) {
        Circle circle = new Circle();
        circle.setCenterX(mouseEvent.getX());
        circle.setCenterY(mouseEvent.getY());
        circle.setRadius(r);
        circle.setFill(farbe);
        pane.getChildren().add(circle);
    }


    public static void main(String[] args)
    {
        zuordnung = new HashMap<>();
        zuordnung.put("rot", Color.RED);
        zuordnung.put("blau", Color.BLUE);
        zuordnung.put("gelb", Color.YELLOW);
        zuordnung.put("grün", Color.GREEN);
        Application.launch(args);
    }
}
