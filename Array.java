public class Array
{
    private int[] list;

    //debugging
    /*public static void main(String[] args)
    {
        Array theRay = new Array(3);
        System.out.println(theRay.list.length);
        theRay.list[0] = 1;
        theRay.list[1] = 5;
        theRay.list[2] = 11;

        System.out.println(theRay.getMiddleIndex());
        System.out.println(theRay.getAvg());
    }*/

    public Array(int numElements)
    {
        list = new int[numElements];
    }

    public int getMiddleIndex()
    {
        int mid = list.length / 2;
        if(list.length % 2 == 0)
            mid--;

        return list[mid];
    }

    public double getAvg()
    {
        return ((double)list[0] + getMiddleIndex() + list[list.length-1]) / list.length;
    }
}
