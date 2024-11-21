import java.util.Scanner;

class NestedDiamondLoop
{
    public static void main(String[] args) 
    {
        System.out.println("Input an ODD number and I'll make a diamond!");
        
        //set up the scanner
        Scanner scan = new Scanner(System.in);
        int chosenNumber = scan.nextInt();
        
        CreateDiamond(chosenNumber);
    }
    
    public static void CreateDiamond(int lines)
    {
        if( (lines % 2) == 0) 
        {
            //error message
            System.out.print("That's even! You're stupid");
            return;
        }
        else
        {
            int splitLine = (lines / 2) + 2; //when to flip
            int spacesAtBeginning = (lines / 2) + 1;
            
            //make the top half of the diamond
            for(int i = 0; i < splitLine; i++)
            {
                //create the adequate amount of offset
                for(int j =0;j<spacesAtBeginning;j++)
                {
                    System.out.print(" ");
                }
                
                //loop through (1 -> line num) amount
                //of asterisks
                for(int k = 1; k <= i; k++)
                {
                    System.out.print("* ");
                }
                
                //bring us down a line; reduce starting offset
                System.out.println();
                spacesAtBeginning--;
            }
            
            spacesAtBeginning += 2;
            
            //bottom half of the diamond
            for(int i = splitLine - 2; i > 0; i--)
            {
                for(int j =0;j<spacesAtBeginning;j++)
                {
                    System.out.print(" ");
                }
                
                for(int k = 1; k <= i; k++)
                {
                    System.out.print("* ");
                }
                
                //bring us down an line; increase offset
                System.out.println();
                spacesAtBeginning++;
            }
        }
    }
}
