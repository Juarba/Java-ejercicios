/*
 * Author: Juan Martin Masqueda, jmasqueda2020@my.fit.edu
 * Course: CSE 1002, Section 4, Spring 2021
 * Project: Politics
*/ 

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Politics {

   public static void main (final String[] args) {
      final Scanner input = new Scanner (System.in, "US-ASCII");
      final LinkedHashMap<String, String> person = new LinkedHashMap<String, String>();
      
      // While there is more inputs.
      while (input.hasNext()) {
         // Input reading.
         final int n = input.nextInt();
         final int m = input.nextInt();
         // if the next input is 0 and 0, break and
         // terminate the program.
         if (n == 0 && m == 0) {
            break;
         }
         // declaration of arrayLists
         final ArrayList<String> candidates = new ArrayList<String>();
         final ArrayList<String> finalList = new ArrayList<String>();
         
         // Loop to add the original candidates to the candidates list
         for (int i = 0; i < n; i++) {
            candidates.add(input.next());
         }

         // Loop to read the inputs.
         for (int j = 0; j < m; j++) {             
            final String supp = input.next();
            final String cand = input.next();
            // If the candidate name is not in the original
            // candidates list, add it at the end.
            if (!candidates.contains(cand)) {
               candidates.add(cand);
            }
            // Add the person to the LinkedHashMap
            person.put(supp, cand);
         }

         // Iterates from the candidates ArrayList
         for (final String candidate : candidates) {
            // Iterates from the person LinkedHashMap keys
            for (final String x : person.keySet()) {
               // If the candidate is equal to the candidate that
               // the person support.
               if (candidate.equals(person.get(x))) {
                  // Add the person into the finalList
                  finalList.add(x);
               }
            }
         }

         // Print the results
         for (final String supporter : finalList) {
            System.out.println(supporter);
         }

      }

   }
}
