public class Board 
{
    public static int pieces;

    public static void Populate()
    {
        pieces = (int)((Math.random() * 29) + 21);
    }

    public static int GetNumPieces()
    {
        return pieces;
    }

    public static void RemovePieces(int num)
    {
        pieces = GetNumPieces() - num;
    }

}
