package PT15;

import java.awt.*;

public class ControllerBank {
    private ViewKonto view;
    private Konto model;
    public ControllerBank(ViewKonto view, Konto model)
    {
        this.model = model;
        this.view = view;
        view.lblKonto.textProperty().bind(model.standProperty().asString());
    }
}
