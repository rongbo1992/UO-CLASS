package Lab3;
/* Rongbo Guo
 * CIS313 
 * Lab2
 * 
 * This is the Heap code to build a heap
 */

@SuppressWarnings({ "unchecked", "hiding" })
public class Heap<Integer extends Comparable<Integer>>
{
   private static final int CAPACITY = 2;

   private int size;            // the size of heap
   private Integer[] heap;     // The array for heap

   public Heap()
   {
      size = 0;
      heap = (Integer[]) new Comparable[CAPACITY];
   }


   public Heap(Integer[] array)
   {
      size = array.length;
      heap = (Integer[]) new Comparable[array.length+1];

      System.arraycopy(array, 0, heap, 1, array.length);//we do not use 0 index

      buildHeap();
   }
 
   public void buildHeap()
   {
      for (int k = size/2; k > 0; k--)
      {
         percolatingDown(k);
      }
   }
   public void percolatingDown(int k)
   {
	  Integer tmp = heap[k];
      int child;

      for(; 2*k <= size; k = child)
      {
         child = 2*k;

         if(child != size &&
            heap[child].compareTo(heap[child + 1]) > 0) child++;

         if(tmp.compareTo(heap[child]) > 0)  heap[k] = heap[child];
         else
                break;
      }
      heap[k] = tmp;
   }

   //Given array of items.
   public void heapSort(Integer[] array)
   {
      size = array.length;
      heap = (Integer[]) new Comparable[size+1];
      System.arraycopy(array, 0, heap, 1, size);
      buildHeap();

      for (int i = size; i > 0; i--)
      {
    	  Integer tmp = heap[i]; //move top item to the end of the heap array
         heap[i] = heap[1];
         heap[1] = tmp;
         size--;
         percolatingDown(1);
      }
      for(int k = 0; k < heap.length-1; k++)
         array[k] = heap[heap.length - 1 - k];
   }
   
   //find the top of the value
   public void findMin() throws RuntimeException
   {
      if (size == 0) throw new RuntimeException();
      Integer min = heap[1];
      System.out.println(min);
	}

   //remove the top of the value
   public Integer removeMin() throws RuntimeException
   {
      if (size == 0) throw new RuntimeException();
      Integer min = heap[1];
      heap[1] = heap[size--];
      percolatingDown(1);
      return min;
	}

   //insert the element to the string.
   public void insert(Integer x)
   {
      if(size == heap.length - 1) doubleSize();

      //Insert a new item to the end of the array
      int pos = ++size;

      //Percolate up
      for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2 )
         heap[pos] = heap[pos/2];

      heap[pos] = x;
   }
   private void doubleSize()
   {
	   Integer [] old = heap;
      heap = (Integer []) new Comparable[heap.length * 2];
      System.arraycopy(old, 1, heap, 1, size);
   }

   public String toString()
   {
      String out = "";
      for(int k = 1; k <= size; k++) out += heap[k]+" ";
      return out;
   }


}