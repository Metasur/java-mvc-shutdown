package View;

import java.awt.event.ActionListener;

public interface I_View {
    String SHUTDOWN = "Apagar";
    String CANCEL = "Cancelar";

    public void controller(ActionListener controller);
    public void message(String message);
    public void error(String message);
}
