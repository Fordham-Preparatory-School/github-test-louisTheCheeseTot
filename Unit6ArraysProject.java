
import java.util.Arrays;
import java.util.Scanner;

public class Unit6ArraysProject
{
    private static int[] theArr = new int[10];

    public static void main(String[] args)
    {
        initializeArray(); //initializes and prints array
        sortArray(); //sorts and prints array
        
        while (true) //allow user to do any of the actions specified in project description
        { 
            System.out.println("Do stuff with the array. Avaliable options:\n[PRINT, SORT, SEARCH, REPLACE, SUM, AVERAGE, MAXIMUM, MINIMUM, SWAP]\n");
            Scanner scan = new Scanner(System.in);
            
            String input = scan.nextLine();

            if(input.toUpperCase().equals("PRINT"))
                printArrayInfo();
            else if(input.toUpperCase().equals("SORT"))
                sortArray();
            else if(input.toUpperCase().equals("SEARCH"))
                searchArray();
            else if(input.toUpperCase().equals("REPLACE"))
                replaceAtIndex();
            else if(input.toUpperCase().equals("SUM"))
                printSum();
            else if(input.toUpperCase().equals("AVERAGE"))
                printAverage();
            else if(input.toUpperCase().equals("MAXIMUM"))
                printMaximum();
            else if(input.toUpperCase().equals("MINIMUM"))
                printMinumum();
            else if(input.toUpperCase().equals("SWAP"))
                swapValues();
        }
    }

    //swaps values of two indecies. asks for index 1 and index 2 then swaps using a temp int
    //if inputted index is smaller or larger, returns error message to user.
    static void swapValues()
    {
        System.out.println("Let's swap two values in the array.");
        Scanner scan = new Scanner(System.in);

        System.out.print("INPUT FIRST INDEX: ");
        int index1 = scan.nextInt();

        if(index1 < 0 || index1 >= theArr.length)
        {
            System.out.println("INVALID INDEX! That's larger/smaller than the array. \n");
            return;
        }

        System.out.print("INPUT SECOND INDEX: ");
        int index2 = scan.nextInt();

        if(index2 < 0 || index2 >= theArr.length)
        {
            System.out.println("INVALID INDEX! That's larger/smaller than the array. \n");
            return;
        }

        System.out.println("-=-SWAPPING AT INDECIES " + index1 + " AND " + index2 + " -=-");
        int temp = theArr[index1];
        theArr[index1] = theArr[index2];
        theArr[index2] = temp;

        printArrayInfo();
    }

    //starts at max, goes through array. if it finds a value smaller than num it will update num.
    static void printMinumum()
    {
        int num = Integer.MAX_VALUE;
        for(int index : theArr)
        {
            if(index < num)
                num = index;
        }

        System.out.println("MINIMUM: " + num + "\n");
    }

    //starts at min, goes through array. if it finds a value larger than num it will update.
    static void printMaximum()
    {
        int num = Integer.MIN_VALUE;
        for(int index : theArr)
        {
            if(index > num)
                num = index;
        }

        System.out.println("MAXIMUM: " + num + "\n");
    }

    //divides the sum of all the numbers by the array's length.
    static void printAverage()
    {
        double avg = (double)getSum() / theArr.length;
        System.out.println("AVERAGE: " + avg+ "\n");
    }

    //prints the sum
    static void printSum()
    {
        System.out.println("SUM: " + getSum() + "\n");
    }

    //goes through array, adds all the values together.
    static int getSum()
    {
        int total = 0;
        for(int i : theArr)
        {
            total += i;
        }

        return total;
    }

    //asks user first for index, then for new value. replaces array at index with new value
    //if the user inputs a number smaller or larger than array, gives them error message.
    static void replaceAtIndex()
    {
        System.out.println("Let's replace the index in the array with a new value.");
        Scanner scan = new Scanner(System.in);

        System.out.print("INPUT INDEX: ");
        int index = scan.nextInt();

        if(index < 0 || index >= theArr.length)
        {
            System.out.println("INVALID INDEX! That's larger/smaller than the array. \n");
            return;
        }

        System.out.print("INPUT NEW VALUE: ");
        int newVal = scan.nextInt();
        
        if(index >= 0 && index < theArr.length)
        {
            System.out.println("Replaced array value at index " + index + " with " + newVal + ". PREVIOUS VALUE: " + theArr[index]);
            theArr[index] = newVal;
            printArrayInfo();
        }
    }

    //searches the array for number inputted from scanner
    static void searchArray()
    {
        System.out.print("Let's check to see if a value is in the array.\nINPUT NUMBER:");

        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();

        int times = 0;
        for(int num : theArr)
        {
            if(num == index)
                times++;
        }

        if(times == 0)
            System.out.println("This array DID NOT contain: " + index + "\n");
        else
            System.out.println("This array DID contain " + index + ", " + times + " time(s)!" + "\n");
    }

    //print the array in a nice format
    static void printArrayInfo()
    {
        String s = "{";
        for(int i=0;i<theArr.length;i++)
        {
            s += theArr[i] + ",";
        }
        s +="}";
        System.out.println("Current Array:" + s + "\n");
    }

    //sets each value of the array to be random
    static void initializeArray()
    {
        for(int i =0;i<theArr.length;i++)
        {
            theArr[i] = (int)(Math.random() * 100) + 1;
        }

        System.out.println("-=-Initializing Array!-=-");
        printArrayInfo();
    }

    //sorts ascending-ly
    static void sortArray()
    {
        Arrays.sort(theArr);
        System.out.println("-=-Sorting Array!-=-");
        printArrayInfo();
    }
}