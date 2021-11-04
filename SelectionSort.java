import java.util.Arrays;
import java.util.Random;
public class SelectionSort
{
    private static int [] randomArray(int n)
    {
        Random rand = new Random();
        int []arr = new int[n];

        for (int i=0; i <arr.length; i ++)
        {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    //method for selection sorting
    public static void selectionSort(int []arr)
    {
        int firstPos =0;
        int lastPos = arr.length -1;
        int temp, smallestPos;

        for(int i = firstPos; i<lastPos; i++)
        {
            smallestPos = i;

            for(int j =i+1; j<=lastPos; j++)
            {
                //if the number at j is smaller than the smallest number, assign j to the smallest number
                if(arr[j] < arr[smallestPos]) smallestPos=j;
            }
            //assigning to smallest value to a temporary variable
            temp = arr[smallestPos];
            //then setting the smallest position to the i position
            arr[smallestPos] = arr[i];
            //setting the position of i to the value stored in temp
            arr[i] = temp;
        }
    }

    //method for bubble sorting
   public static void bubbleSort(int []arr)
   {
       int n = arr.length;
       int temp =0;

       for(int i=0; i<n; i++)
       {
           for (int j=1; j<(n-i); j++)
           {
               if (arr[j-1] > arr[j])
               {
                   temp = arr[j-1];
                   arr[j-1] = arr[j];
                   arr[j] = temp;
               }
           }
       }
   }



    public static void main (String [] args)
    {
        int [] arr = randomArray(10);
        bubbleSort(arr);
        System.out.println("Array sorted = " + Arrays.toString(arr));
    }


}
