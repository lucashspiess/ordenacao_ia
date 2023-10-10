import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    public Interface() {
        JTextArea txtInput = new JTextArea();
        JTextArea txtOutput = new JTextArea();
        JTextArea txtRegras = new JTextArea();
        JButton btnOrdenar = new JButton("Ordenar");

        setTitle("Ordenação de poços de visita");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(700, 400);

        JPanel geralPanel = new JPanel(new GridLayout(1,2));

        JPanel regrasPanel = new JPanel(new GridLayout(1,1));

        JPanel textAreasPanel = new JPanel(new GridLayout(2, 1));
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Relatório desordenado"), BorderLayout.NORTH);
        txtInput.setLineWrap(true);
        inputPanel.add(new JScrollPane(txtInput), BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Relatório ordenado"), BorderLayout.NORTH);
        txtOutput.setLineWrap(true);
        txtOutput.setEditable(false);
        outputPanel.add(new JScrollPane(txtOutput), BorderLayout.CENTER);

        JPanel regras = new JPanel(new BorderLayout());
        regras.add(new JLabel("Regras"), BorderLayout.NORTH);
        txtRegras.setLineWrap(true);
        txtRegras.setEditable(false);
        regras.add(new JScrollPane(txtRegras), BorderLayout.CENTER);

        textAreasPanel.add(inputPanel);
        textAreasPanel.add(outputPanel);
        regrasPanel.add(regras);

        geralPanel.add(textAreasPanel);
        geralPanel.add(regrasPanel);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(btnOrdenar);
        txtRegras.setFont(new Font("Roboto", Font.PLAIN,16));

        add(geralPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        btnOrdenar.addActionListener(e -> {
            String input = txtInput.getText();
            StringBuilder regrasEncontradas =  new StringBuilder();
            input = Ordenacao.ordena(input, regrasEncontradas);
            txtOutput.setText(input);
            txtRegras.setText(regrasEncontradas.toString());
        });

        setLocationRelativeTo(null);
        setVisible(true);
        this.setResizable(false);
    }
}