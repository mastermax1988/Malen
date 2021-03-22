package PT15;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Konto {
    private DoubleProperty stand = new SimpleDoubleProperty(0);
    public final double getStand()
    {
        return stand.get();
    }
    public final void setStand(double d)
    {
        stand.set(d);
    }
    public final DoubleProperty standProperty()
    {
        return stand;
    }
    public void zahleEin(double d)
    {
        if(d<0)
            return;
        setStand(getStand()+d);
    }
    public void zahleAus(double d)
    {
        if(d<0 || d>getStand())
            return;
        setStand(getStand()-d);
    }

}
