package View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JPanel implements I_View {
    private JLabel label, message, title;
    private JButton shutdown, cancel;
    private JTextField input;

    public View() {
        this.setLayout(new BorderLayout());

        this.title = new JLabel("Introduzca los minutos para apagar el sistema");
        this.title.setHorizontalAlignment(SwingConstants.CENTER);

        this.input = new JTextField(20);
        this.input.setBorder(new TitledBorder("Minutos: "));

        this.shutdown = new JButton(this.SHUTDOWN);
        this.cancel = new JButton(this.CANCEL);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        buttons.add(this.cancel, BorderLayout.WEST);
        buttons.add(this.shutdown, BorderLayout.EAST);

        add(this.title, BorderLayout.NORTH);
        add(this.input, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }

    @Override
    public void controller(ActionListener controller) {
        this.shutdown.addActionListener(controller);
        this.shutdown.setActionCommand(I_View.SHUTDOWN);

        this.cancel.addActionListener(controller);
        this.cancel.setActionCommand(I_View.CANCEL);
    }

    public int getMinutes() {
        String input = this.input.getText();
        int minutes = 0;

        try {
            if(input.isEmpty()) {
                throw new Exception("Por favor, introduzca un valor");
            } else {
                minutes = Integer.parseInt(input);
                if(minutes <= 0) {
                    minutes = 0;
                    throw new Exception("Por favor, introduzca un valor estrictamente positivo");
                }
            }
        } catch(Exception exception) {
            this.error(exception.getMessage());
        }
        return minutes;
    }

    @Override
    public void message(String message) {
        this.title.setForeground(Color.BLUE);
        this.title.setText(message);
    }

    @Override
    public void error(String message) {
        this.title.setForeground(Color.RED);
        this.title.setText(message);
    }
}
