public class Diagonal
{
    private static int[][] array = 
    {{2,3,4,5,6},{2,3,4,5,6},{2,3,4,5,6},{2,3,4,5,6},{2,3,4,5,6}};

    public static void main(String[] args)
    {
        System.out.print("diagonal sum = " + (diagonal1() + diagonal2()));
    }

    public static int diagonal1()
    {
        int sum = 0;

        for(int i =0;i<array.length;i++)
        {
            sum += array[i][i];
        }

        return sum;
    }

    public static int diagonal2()
    {
        int sum = 0;

        for(int i =0;i<array.length;i++)
        {
            sum += array[i][array.length - 1 - i];
        }

        return sum;
    }
}
