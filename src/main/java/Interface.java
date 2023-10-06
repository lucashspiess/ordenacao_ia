import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    public Interface() {
        JTextArea txtInput = new JTextArea();
        JTextArea txtOutput = new JTextArea();
        JButton btnOrdenar = new JButton("Ordenar");

        setTitle("Ordenação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(700, 200);

        JPanel textAreasPanel = new JPanel(new GridLayout(1, 2));
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Input"), BorderLayout.NORTH);
        inputPanel.add(new JScrollPane(txtInput), BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Output"), BorderLayout.NORTH);
        outputPanel.add(new JScrollPane(txtOutput), BorderLayout.CENTER);

        textAreasPanel.add(inputPanel);
        textAreasPanel.add(outputPanel);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(btnOrdenar);

        add(textAreasPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        btnOrdenar.addActionListener(e -> {
            String input = txtInput.getText();
            input = Ordenacao.ordena(input);
            txtOutput.setText(input);
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}