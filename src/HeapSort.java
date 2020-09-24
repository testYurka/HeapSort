import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    public void sort(List<Integer> list)
    {
        int n = list.size();


        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);


        for (int i=n-1; i>=0; i--)
        {

            int temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);


            heapify(list, i, 0);
        }
    }


    void heapify(List<Integer> list, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;


        if (l < n && list.get(l) > list.get(largest))
            largest = l;


        if (r < n && list.get(r) > list.get(largest))
            largest = r;

        if (largest != i)
        {
            int swap =   list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);


            heapify(list, n, largest);
        }
    }




    public static void main(String args[])
    {
        List<Integer> list = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            while(true)
            {
                list.add(Integer.parseInt(reader.readLine()));
            }
        }
        catch (Exception e)
        {
            System.out.println("Final");
        }
finally
        {
            HeapSort ob = new HeapSort();
            ob.sort(list);

            System.out.println("Sorted array is");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
