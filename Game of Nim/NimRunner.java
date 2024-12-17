import javax.swing.*;

public class NimRunner
{
    static TheGameOfNim gameOfNim;

    public static void main(String[] args)
    {
        SetupGame();
    }

    public static void SetupGame()
    {
        Board.Populate();
        if(gameOfNim == null)
        {
            gameOfNim = new TheGameOfNim(new NimGameStartupUI());
        }

        gameOfNim.UpdateUI();
        //gameOfNim.Play(); although required for project credit, this cannot go here.
        //instead it's called in the actual button that says "Play Nim!"
    }

    public static void EndGame()
    {
        new NimGameOverUI();
    }
}

//this will start the game!
class NimGameStartupUI
{
    public JFrame popupBox;
    public JTextArea player1NameInput, player2NameInput;

    //sets up the ui
    public NimGameStartupUI() 
    {
        popupBox = new JFrame("Nim");

        JPanel panel = new JPanel(null);
        popupBox.add(panel);

        JLabel labelOne = new JLabel("Select your player names!", 0);

        player1NameInput = new JTextArea("Player 1");
        player2NameInput = new JTextArea("Player 2");


        //START THE GAME BUTTON
        JButton button = new JButton("Play Nim!");
        button.addActionListener( evt -> 
        {        
            popupBox.dispose();
            NimRunner.gameOfNim.Play();
        });

    
        labelOne.setBounds(20,15,200,50);
        player1NameInput.setBounds(20,50,200,20);
        player2NameInput.setBounds(20,75,200,20);
        button.setBounds(65,100,100,30);

        panel.add(labelOne);
        panel.add(player1NameInput);
        panel.add(player2NameInput);
        panel.add(button);

        popupBox.setSize(250,175);
        popupBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        popupBox.setLocationRelativeTo(null);
        popupBox.setResizable(false);
        popupBox.setVisible(true);
    }
}

class NimGameOverUI
{
    public JFrame popupBox;

    //sets up the ui
    public NimGameOverUI() 
    {
        popupBox = new JFrame("Nim");

        JPanel panel = new JPanel(null);
        popupBox.add(panel);

        JLabel labelOne = new JLabel(TheGameOfNim.currentPlayer.name + " won the game!", 0);
        JLabel labelTwo = new JLabel(TheGameOfNim.player1.GetName() + " : " + TheGameOfNim.player1.GetScore(), 0);
        JLabel labelThree = new JLabel(TheGameOfNim.player2.GetName() + " : " + TheGameOfNim.player2.GetScore(), 0);

        //START THE GAME BUTTON
        JButton button = new JButton("Play Again");
        button.addActionListener( evt -> 
        {        
            popupBox.dispose();
            NimRunner.SetupGame();
            NimRunner.gameOfNim.Play();
        });

    
        labelOne.setBounds(20,15,200,50);
        labelTwo.setBounds(20,50,200,50);
        labelThree.setBounds(20,75,200,50);
        button.setBounds(65,120,100,30);

        panel.add(labelOne);
        panel.add(labelTwo);
        panel.add(labelThree);
        panel.add(button);

        popupBox.setSize(250,200);
        popupBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        popupBox.setLocationRelativeTo(null);
        popupBox.setResizable(false);
        popupBox.setVisible(true);
    }
}
