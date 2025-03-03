import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class SortingSearchProject
{
    private static int[] array = new int[10000];

     public static void main(String[] args)
    {
        initializeArray();

        while (true) //allow user to do any of the actions specified in project description
        { 
            System.out.println("--------------------");
            Scanner scan = new Scanner(System.in);
            System.out.print("Input TARGET NUMBER: ");
            Integer targetInput = Integer.parseInt(scan.nextLine());
            System.out.print("Input Command: [SORT, LINEAR SEARCH, BINARY SEARCH]: ");
            String sortType = scan.nextLine();
            System.out.println("--------------------");

            if(sortType.toUpperCase().equals("SORT"))
                selectionSort();
            else if(sortType.toUpperCase().equals("LINEAR SEARCH"))
                linearSearch(targetInput);
            else if(sortType.toUpperCase().equals("BINARY SEARCH"))
                binarySearch(targetInput);
        }
    }

    private static void selectionSort()
    {
        boolean foundValue = false;
        LocalTime start = LocalTime.now();
        for(int i =0;i<array.length;i++)
        {
            for(int j=i+1;j<array.length;j++)
            {
                if(array[i] > array[j])
                {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }

            System.out.println(array[i] + " ");
        }

        LocalTime end = LocalTime.now();
        System.out.println("Start Time: " + start);
        System.out.println("End Time: " + end);
        System.out.println("TOTAL OPERATION TIME: " + Duration.between(start, end).toMillis() + "ms");
        System.out.println("SUCESSFULLY SORTED!");
    }

    private static void linearSearch(int index)
    {
        boolean foundValue = false;
        LocalTime start = LocalTime.now();
        for(int i =0;i<array.length;i++)
            if(array[i] == index) 
            {
                foundValue = true;
                break;
            }
        
        LocalTime end = LocalTime.now();
        System.out.println("Start Time: " + start);
        System.out.println("End Time: " + end);
        System.out.println("TOTAL OPERATION TIME: " + Duration.between(start, end).toMillis() + "ms");
        System.out.println(("[OPERATION STATUS] FOUND VALUE: " + foundValue).toUpperCase());
    }

    private static void binarySearch(int index)
    {
        int i = 0;
        int j = array.length - 1;
        boolean foundValue = false;
        LocalTime start = LocalTime.now();
        
        while(i <= j)
        {
            int curNum = i + (j - i) / 2;
            if(array[curNum] > index)
            {
                j= curNum - 1;
            }
            else if(array[curNum] < index)
            {
                i = curNum + 1;
            }
            else if(array[curNum] == index)
            {
                foundValue = true;
            }
        }

        LocalTime end = LocalTime.now();
        System.out.println("Start Time: " + start);
        System.out.println("End Time: " + end);
        System.out.println("TOTAL OPERATION TIME: " + Duration.between(start, end).toMillis() + "ms");
        System.out.println(("[OPERATION STATUS] FOUND VALUE: " + foundValue).toUpperCase());
    }

    private static void initializeArray()
    {
        for(int i =0;i<array.length;i++)
        {
            array[i] = (int)(Math.random() * 199998) - 99999;
        }
    }
}
