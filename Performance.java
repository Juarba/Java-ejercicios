/*
 * Author: Juan Martin Masqueda, jmasqueda2020@my.fit.edu
 * Course: CSE 1002, Section 4, Spring 2021
 * Project: Performance
*/
import java.util.Collections;
import java.util.Random;
import java.util.List;


public final class Performance {
   
   public static void sort (final List<Integer> data) {

      for (int i = 0; i < data.size(); i++) {
         /* find the min element in the unsorted data[i, i+1, .., n-1] */
         /* assume initially that min is the first element in the range */
         int min = i;
         for (int j = i + 1; j < data.size(); j++) {
            /* if the 'j'th element is less, then it is the new minimum */
            if (data.get(min) > data.get(j)) {
               /* found new minimum; remember its index */
               min = j;
            }
         }  
         /* swapping */
         final int temp = data.get(min);
         data.set(min, data.get(i));
         data.set(i, temp);
      }
   }


   public static void main (final String[] args) throws Exception {
      final Random rnd = new Random (Long.getLong ("seed", System.nanoTime()));
      final int n = Integer.parseInt(args[0]);
      final Class<?> clazz = Class.forName(args[1]);
      @SuppressWarnings("unchecked")
      final java.util.List<Integer> list = (java.util.List<Integer>) 
            clazz.getDeclaredConstructor().newInstance();

      long startTime, endTime, total = 0;
      final int REPETITIONS = 25;
      // Fill the list.
      for (int j = 0; j < n; j++) {
         list.add(j);
      }

      for (int i = 0; i < REPETITIONS; i++) {
         // Shuffle
         Collections.shuffle(list, rnd);
         startTime = System.nanoTime();
         // Sort
         sort(list);

         endTime = System.nanoTime();
         total += endTime - startTime;
      }
      final long averageTime = total / REPETITIONS;
      // Convert average time from nanoseconds to seconds.
      final double averageSeconds = (double) averageTime / 1000000000;
      // Print the seconds.
      System.out.println(averageSeconds);
   }
}
