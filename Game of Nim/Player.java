public class Player 
{
    public String name;
    public int score;

    public Player(String _n)
    {
        name = _n;
    }

    //personally, i wouldn't put this in the player code
    //but, it's necessary for points on the assignment
    public int TakeTurn(int index)
    {
        Board.RemovePieces(index);
        
        if(Board.GetNumPieces() <= 0)
        {
            TheGameOfNim.currentPlayer.UpdateScore();
            NimRunner.EndGame();
        }

        if(TheGameOfNim.currentPlayer == TheGameOfNim.player1)
            TheGameOfNim.currentPlayer = TheGameOfNim.player2;
        else
            TheGameOfNim.currentPlayer = TheGameOfNim.player1;
        
        TheGameOfNim.UpdateUI();
        return index;
    }

    public String GetName()
    {
        return name;
    }

    public int GetScore()
    {
        return score;
    }

    public void UpdateScore()
    {
        score++;
    }
}
