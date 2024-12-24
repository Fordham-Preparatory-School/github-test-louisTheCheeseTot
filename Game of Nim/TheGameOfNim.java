import java.awt.*;
import javax.swing.*;

public class TheGameOfNim 
{
    public static Player player1, player2;
    public static Player currentPlayer;

    private static NimGameStartupUI startupUI;
    public static NimGameUI gameUI;

    //initiate the game of nim
    public TheGameOfNim(NimGameStartupUI _startupUI)
    {
        startupUI = _startupUI;

        //can probably get rid of this, check it out later
        player1 = new Player(startupUI.player1NameInput.getText());
        player2 = new Player(startupUI.player2NameInput.getText());
    }

    public static void Play()
    {
        if(gameUI == null)gameUI = new NimGameUI();

        //get player names
        player1 = new Player(startupUI.player1NameInput.getText());
        player2 = new Player(startupUI.player2NameInput.getText());

        //pick random starting player
        if(Math.random() > .5) currentPlayer = player1;
        else currentPlayer = player2;
        
        UpdateUI();
    }

    public static void UpdateUI()
    {
        gameUI.flagsDisplayArea.setText("");
        for(int i =0; i <Board.pieces; i++)
        {
            gameUI.flagsDisplayArea.setText(gameUI.flagsDisplayArea.getText() + "⚑ ");
        }
        gameUI.flagsDisplayNumber.setText("There are " + Board.pieces + " flags on the board.");
        gameUI.currentPlayersTurn.setText(currentPlayer.name + "'s Turn!");
    }
}

//the actual game popup
class NimGameUI
{
    public JFrame popupBox;
    public JLabel currentPlayersTurn, flagsDisplayNumber;
    public JTextArea flagsDisplayArea;

    public NimGameUI() 
    {
        popupBox = new JFrame("The Game Of Nim");

        JPanel panel = new JPanel(null);
        popupBox.add(panel);
        
        flagsDisplayNumber = new JLabel("There are 50 flags on the board.",0);
        flagsDisplayNumber.setBounds(110, 220, 400, 50);
        panel.add(flagsDisplayNumber);

        //this code is a disaster. let's fix this up eventually.
        JButton button = new JButton("ONE Flag");
        button.addActionListener( evt -> {TheGameOfNim.currentPlayer.TakeTurn(1); });
        panel.add(button);

        JButton button2 = new JButton("TWO Flags");
        button2.addActionListener( evt -> {TheGameOfNim.currentPlayer.TakeTurn(2); });
        panel.add(button2);

        JButton button3 = new JButton("THREE Flags");
        button3.addActionListener( evt -> {TheGameOfNim.currentPlayer.TakeTurn(3); });
        panel.add(button3);

        //holy moly 
        flagsDisplayArea = new JTextArea();
        flagsDisplayArea.setEditable(false);
        flagsDisplayArea.setBounds(110,35,400,200);
        flagsDisplayArea.setLineWrap(true);
        flagsDisplayArea.setWrapStyleWord(true);
        flagsDisplayArea.setFont(new Font("Ariel", Font.PLAIN, 30));
        panel.add(flagsDisplayArea);
    
        currentPlayersTurn = new JLabel("Player 1's Turn!", 0);
        currentPlayersTurn.setBounds(110, 250, 400, 50);
        panel.add(currentPlayersTurn);

        button.setBounds(90,320,120,50);
        button2.setBounds(245,320,120,50);
        button3.setBounds(405,320,120,50);

        popupBox.setSize(650,450);
        popupBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        popupBox.setLocationRelativeTo(null);
        popupBox.setResizable(false);
        popupBox.setVisible(true);

        //lets use a grid layout group for this part
    }
}
