import java.awt.event.*;
import javax.swing.*;

public class Jumpy8Ball
{
    static String currentText;
    static boolean jumping;
    static private int currentPlaceInJump;
    static private GameUI gameUI;

    static final int[] jumpingCurve = {0,1,2,3,4,4,3,2,1}; //player's height during jump. unchanging.
    static final String mapPieces[] = 
    {
        "███████████████████▒▒▒▒▒▒",
        "█████████▒▒▒▒▒▒██████████",
        "███▒▒███████▒▒███████████",
        "███▒▒▒▒█████████▒▒▒██████",
        "███████▒▒▒▒▒▒███████▒▒███",
        "██████████████▒▒█████████",
        "██████▒▒▒▒▒▒████████▒▒▒██",
        "████████████████▒▒▒██████",
    }; //randomly generated map pieces.

    public static void main(String[] args)
    {
        SetupNewGame();
    }

    public static void SetupNewGame()
    {
        if(gameUI == null) gameUI = new GameUI();
        
        String map ="████████";
        for(int i = 0;i<1000;i++) //make a really long map
        {
            map += mapPieces[(int)(Math.random() * mapPieces.length)];
        }
        currentText = map.substring(0,15);

        Update(map);
    }

    public static void Update(String map)
    {
        //put the update on a seperate thread so that when 8 ball crashes,
        //the update loop doesnt stop the new game ui box from being updated
        Thread newThread = new Thread(() -> 
        {
            int placeInGround = 0;

            while (true) 
            { 
                //calculate where we are in jumping curve
                if(jumping)
                {
                    currentPlaceInJump++;
                    if(currentPlaceInJump >= jumpingCurve.length)
                    {
                        currentPlaceInJump = 0;
                        jumping = false;
                    }
                }
    
                //fell in a pit!
                if(currentText.substring(0,2).equals("▒▒") && !jumping)
                {
                    new GameOverUI((int)(placeInGround / 25) - 1);
                    return;
                }
    
                //tick character one character forward
                Draw(placeInGround, map);
                placeInGround++;
    
                //start at 75 ms intervals, or around 13.3 fps. every 50 meters we move, make the game speed up
                try {Thread.sleep(75 - (int)(placeInGround/50));} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
            }
        });
        newThread.start();
    }

    public static void Draw(int i, String map)
    {
        ///THIS CAN PROBABLY BE OPTIMIZED LATER ON
      
        //draw the player's position
        String cube = "";
        for(int j =4;j>jumpingCurve[currentPlaceInJump];j--) //area above player
        {
            cube += "\n";
        }
        cube += "❽ \n"; //player
        for(int j =0;j<jumpingCurve[currentPlaceInJump];j++) //area below player
        {
            cube += "\n";
        }

        //drawing the player
        currentText = currentText.substring(1) + map.substring(i, i + 1);
        gameUI.area.setText(cube + currentText);
    }
}

class GameUI implements ActionListener 
{
    public JFrame theFrame;
    public JTextArea area;

    public GameUI() 
    {
        theFrame = new JFrame("Jumpy 8 Ball");
        JPanel panel = new JPanel(null);
        theFrame.add(panel);

        JButton button = new JButton("Jump!");
        area = new JTextArea();

        button.addActionListener(this);
        area.setBounds(100,35,180,100);
        button.setBounds(150,155,80,30);

        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        panel.add(area);
        panel.add(button);

        theFrame.setSize(400,250);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setLocationRelativeTo(null);
        theFrame.setResizable(false);
        theFrame.setVisible(true);
    }

    // jump
    public void actionPerformed(ActionEvent e) {
        Jumpy8Ball.jumping = true;
    }
}

class GameOverUI implements ActionListener 
{
    JFrame theFrame;

    public GameOverUI(int score) 
    {
        theFrame = new JFrame("L");
        JPanel panel = new JPanel(null);
        theFrame.add(panel);
    

        JButton button = new JButton("Play Again!");
        JLabel _area = new JLabel("Your score was: " + score);

        button.addActionListener(this);
        _area.setBounds(40,0,200,100);
        button.setBounds(30,70,120,30);

        panel.add(_area);
        panel.add(button);

        theFrame.setSize(200,150);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.setLocationRelativeTo(null);
        theFrame.setResizable(false);
        theFrame.setVisible(true);
    }

    // close the game over box, restart the game
    public void actionPerformed(ActionEvent e) {
        theFrame.dispose();
        Jumpy8Ball.SetupNewGame();
    }
}
