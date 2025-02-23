public class BinarySearch
{

    //precondition: array is in increasing order
    public int search(int[] arr, int target)
    {
        int i = 0;
        int j = arr.length - 1;
        while(i <= j)
        {
            int curNum = i + (j - i) / 2;
            if(arr[curNum] > target)
            {
                j= curNum - 1;
            }
            else if(arr[curNum] < target)
            {
                i = curNum + 1;
            }
            else if(arr[curNum] == target)
            {
                return arr[curNum];
            }
        }

        return -1;
    }
}
