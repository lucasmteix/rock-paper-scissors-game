import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class main {
    private static String[] opcoes = {"Pedra", "Papel", "Tesoura"};
    private static int jogadorEscolha = -1; // -1 representa que o jogador ainda não escolheu

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // Aplica o tema FlatLaf
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            // Criar janela do jogo
            JFrame frame = new JFrame("Pedra, Papel ou Tesoura");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            // Criação do painel principal
            JPanel painel = new JPanel();
            painel.setLayout(new GridLayout(2, 1)); // Duas linhas, uma para os botões e outra para o resultado
            frame.add(painel, BorderLayout.CENTER);

            // Labels para mostrar o resultado
            JLabel resultadoLabel = new JLabel("Escolha uma opção:", SwingConstants.CENTER);
            painel.add(resultadoLabel);

            // Criar botões para as opções
            JPanel botoesPanel = new JPanel();
            botoesPanel.setLayout(new FlowLayout());
            JButton pedraButton = new JButton("Pedra");
            JButton papelButton = new JButton("Papel");
            JButton tesouraButton = new JButton("Tesoura");

            botoesPanel.add(pedraButton);
            botoesPanel.add(papelButton);
            botoesPanel.add(tesouraButton);
            painel.add(teouraButton);

            // Ação do botão Pedra
            pedraButton.addActionListener(e -> {
                jogadorEscolha = 0;
                resultadoLabel.setText("Você escolheu: Pedra");
                jogar(resultadoLabel);
            });

            // Ação do botão Papel
            papelButton.addActionListener(e -> {
                jogadorEscolha = 1;
                resultadoLabel.setText("Você escolheu: Papel");
                jogar(resultadoLabel);
            });

            // Ação do botão Tesoura
            tesouraButton.addActionListener(e -> {
                jogadorEscolha = 2;
                resultadoLabel.setText("Você escolheu: Tesoura");
                jogar(resultadoLabel);
            });

            frame.setVisible(true);
        });
    }

    private static void jogar(JLabel resultadoLabel) {
        if (jogadorEscolha == -1) return; // Caso o jogador ainda não tenha escolhido

        // Computador escolhe aleatoriamente
        Random random = new Random();
        int computadorEscolha = random.nextInt(3);

        // Mostra a escolha do computador
        String computadorEscolhaStr = opcoes[computadorEscolha];
        resultadoLabel.setText(resultadoLabel.getText() + " | Computador escolheu: " + computadorEscolhaStr);

        // Determina o vencedor
        if (jogadorEscolha == computadorEscolha) {
            resultadoLabel.setText(resultadoLabel.getText() + " | Empate!");
        } else if ((jogadorEscolha == 0 && computadorEscolha == 2) ||
                (jogadorEscolha == 1 && computadorEscolha == 0) ||
                (jogadorEscolha == 2 && computadorEscolha == 1)) {
            resultadoLabel.setText(resultadoLabel.getText() + " | Você venceu!");
        } else {
            resultadoLabel.setText(resultadoLabel.getText() + " | Computador venceu!");
        }
    }
}