import javax.swing.*;
import View.View;
import Controller.Controller;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.controller(controller);
        JFrame window = new JFrame("Apagado automático");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(view);
        window.pack();
        window.setVisible(true);
    }
}
