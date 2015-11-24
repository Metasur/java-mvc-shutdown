package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Shutdown;
import View.View;

public class Controller implements ActionListener {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            if(cmd.equals(View.SHUTDOWN)) {
                int minutes = this.view.getMinutes();
                Shutdown.Shutdown(minutes);
                this.view.message("El ordenador se apagará en " + minutes + " minutos...");
            } else if(cmd.equals(View.CANCEL)){
                Shutdown.Cancel();
                this.view.message("Cancelando apagado automático...");
            }
        } catch(Exception exception) {
            view.error(exception.getMessage());
        }
    }
}
