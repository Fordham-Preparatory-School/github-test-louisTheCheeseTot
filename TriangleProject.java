import java.util.Scanner;

public class TriangleProject
{
    public static void main(String[] args)
    {
        System.out.println("Lets create a triangle! Input a number to indicate the number of lines.");
        
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        
        CreateAnAsteriskTriangle(input);
    }
    
    public static void CreateAnAsteriskTriangle(int numberOfLines)
    {
        numberOfLines++;
        for(int i =1;i<numberOfLines;i++)
        {
            if(i == numberOfLines - 1)
            {
                for(int j=0;j<i;j++)
                {
                    System.out.print("*");
                }
            }
            else
            {
                for(int j=0;j<i;j++)
                {
                    if(j == 0 || j == i - 1)
                    {
                        System.out.print("* ");
                        
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                    
                }
            }
            System.out.println(" ");
        }
    }
}
