import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    private static String[] options = {"Rock", "Paper", "Scissors"};
    private static int playerChoice = -1; // -1 represents the player hasn't picked
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // applies the FlatLaf theme
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {

            // Creating the game window
            JFrame frame = new JFrame("Rock Paper Scissors");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            // Creating the main panel
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1)); // two lines, one for buttons and another for the result
            frame.add(panel, BorderLayout.CENTER);

            // Labels
            JLabel resultLabel = new JLabel("Pick an option:", SwingConstants.CENTER);
            panel.add(resultLabel);

            // Creating buttons for the options
            JPanel panelButtons = new JPanel();
            panelButtons.setLayout(new FlowLayout());
            JButton rockButton = new JButton("Rock");
            JButton paperButton = new JButton("Paper");
            JButton scissorsButton = new JButton("Scissors");

            panelButtons.add(rockButton);
            panelButtons.add(paperButton);
            panelButtons.add(scissorsButton);
            panel.add(panelButtons);

            // Rock button action
            rockButton.addActionListener(e -> {
                playerChoice = 0;
                resultLabel.setText("You picked: rock");
                play(resultLabel);
            });

            // Paper button action
            paperButton.addActionListener(e -> {
                playerChoice = 1;
                resultLabel.setText("You picked: paper");
                play(resultLabel);
            });

            // Scissors button option
            scissorsButton.addActionListener(e -> {
                playerChoice = 2;
                resultLabel.setText("You picked: scissors");
                play(resultLabel);
            });

            frame.setVisible(true);
        });
    }

    private static void play(JLabel resultLabel) {
        if (playerChoice == -1) return; // in case the player hasn't picked

        // Computer randomly selects an option
        Random random = new Random();
        int computerChoice = random.nextInt(3);

        // Shows the computer choice
        String computerChoiceStr = options[computerChoice];
        resultLabel.setText(resultLabel.getText() + " | Computer picked: " + computerChoiceStr);

        // Determines the winner
        if (playerChoice == computerChoice) {
            resultLabel.setText(resultLabel.getText() + " | Draw!");
        } else if ((playerChoice == 0 && computerChoice == 2) ||
                (playerChoice == 1 && computerChoice == 0) ||
                (playerChoice == 2 && computerChoice == 1)) {
            resultLabel.setText(resultLabel.getText() + " | You won!");
        } else {
            resultLabel.setText(resultLabel.getText() + " | Computer won!");
        }
    }
}