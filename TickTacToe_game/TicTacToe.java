import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private boolean playerX = true;
    private JLabel statusLabel;
    private int roundsToPlay;
    private int scoreX = 0, scoreO = 0;
    private int gamesPlayed = 0;

    public TicTacToe(int rounds) {
        this.roundsToPlay = rounds;
        setTitle("Tic Tac Toe");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(50, 50, 50));

        
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(new Color(30, 30, 30));
        
        statusLabel = new JLabel("Player X's Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setOpaque(true);
        statusLabel.setBackground(new Color(70, 130, 180));
        add(statusLabel, BorderLayout.NORTH);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBackground(new Color(200, 200, 200));
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
        
        JButton resetButton = new JButton("Restart Match");
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.setBackground(new Color(255, 69, 0));
        resetButton.setForeground(Color.WHITE);
        resetButton.addActionListener(e -> resetGame());
        add(resetButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (!clickedButton.getText().equals("")) {
            return;
        }
        
        clickedButton.setText(playerX ? "X" : "O");
        clickedButton.setEnabled(false);
        clickedButton.setBackground(playerX ? new Color(173, 216, 230) : new Color(255, 160, 122));
        
        if (checkWin()) {
            if (playerX) {
                scoreX++;
            } else {
                scoreO++;
            }
            gamesPlayed++;
            
            statusLabel.setText("Player " + (playerX ? "X" : "O") + " Wins! Score: X=" + scoreX + " O=" + scoreO);
            disableButtons();
            checkGameCompletion();
        } else if (isBoardFull()) {
            gamesPlayed++;
            statusLabel.setText("It's a Draw! Score: X=" + scoreX + " O=" + scoreO);
            checkGameCompletion();
        } else {
            playerX = !playerX;
            statusLabel.setText("Player " + (playerX ? "X" : "O") + "'s Turn");
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().equals("")) {
                return true;
            }
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().equals("")) {
                return true;
            }
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().equals("")) {
            return true;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().equals("")) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private void resetGame() {
        if (gamesPlayed >= roundsToPlay) {
            JOptionPane.showMessageDialog(this, "Game Over! Final Score: X=" + scoreX + " O=" + scoreO);
            System.exit(0);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(new Color(200, 200, 200));
            }
        }
        playerX = true;
        statusLabel.setText("Player X's Turn");
    }

    private void checkGameCompletion() {
        if (gamesPlayed < roundsToPlay) {
            JOptionPane.showMessageDialog(this, "Next Round Begins!");
            resetGame();
        } else {
            JOptionPane.showMessageDialog(this, "Game Over! Final Score: X=" + scoreX + " O=" + scoreO);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter number of rounds to play:");
        int rounds = (input != null && !input.isEmpty()) ? Integer.parseInt(input) : 1;
        SwingUtilities.invokeLater(() -> {
            TicTacToe game = new TicTacToe(rounds);
            game.setVisible(true);
        });
    }
}