package PT15;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.*;

public class ControllerBank {
    private ViewKonto view;
    private Konto model;
    public ControllerBank(ViewKonto view, Konto model)
    {
        this.model = model;
        this.view = view;
        view.lblKonto.textProperty().bind(model.standProperty().asString());
        view.btnAuszahlen.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double betrag = 0;
                try {
                    betrag = Double.parseDouble(view.txtKonto.getText());
                }
                catch (Exception e)
                {
                    view.alertBetrag.show();
                    return;
                }
                if(betrag<0)
                {
                    view.alertPositiv.show();
                    return;
                }
                if(model.getStand()<betrag)
                {
                    view.alertDeckung.show();
                    return;
                }
                model.zahleAus(betrag);
            }
        });
        view.btnEinzahlen.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               double betrag = 0;
                try {
                    betrag = Double.parseDouble(view.txtKonto.getText());
                }
                catch (Exception e)
                {
                    view.alertBetrag.show();
                    return;
                }
                if(betrag<0)
                {
                    view.alertPositiv.show();
                    return;
                }
                model.zahleEin(betrag);
            }
        });
    }
}
