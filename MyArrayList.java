/*
 * Author: Juan Martín Masqueda, jmasqueda2020@my.fit.edu
 * Course: CSE 1002, Section 4, Spring 2021
 * Project: MyArrayList
*/

import java.util.Scanner;

public class MyArrayList {
   // declare variables
   private static final int DEFAULT_SIZE = 10;
   private static Integer[] array;
   private int index;
   private int size;

   // MyArrayList contructor without parameter.
   public MyArrayList() {
      this.array = new Integer[DEFAULT_SIZE];
      this.size = DEFAULT_SIZE;
   }

   // MyArrayList constructor with parameter
   public MyArrayList(final int initialCapacity){
      this.array = new Integer[initialCapacity];
      this.size = initialCapacity;
   }

   // ensureCapacity to add capacity to the array
   private void ensureCapacity(final int minCapacity){
      int newSize = this.size + minCapacity  ;
      // Creates an array with new size
      Integer newArray[] = new Integer[newSize];
      // Copy the elements from old array to new one with more capacity
      for(int i = 0; i < array.length; i++){
         newArray[i] = array[i];
      }
      newArray[array.length] = null;
      this.array = newArray;
   }

   public boolean add(final Integer element){
      boolean added = false;
      // Check if the array is full
      if(this.index == this.size - 1){
         //we need to increase the size of data[]
         ensureCapacity(1);
         added = true;
      }
      array[array.length-1] = element;
      this.index++;

      return added;

   }

   // Return element in the given index.
   public Integer get(final int index) throws IndexOutOfBoundsException {
      if ( index < 0 || index > size()) {
         throw new IndexOutOfBoundsException();
      }

      return this.array[index];
   }

   // Set an element in the index given.
   public Integer set(final int index, final Integer element) throws IndexOutOfBoundsException {
      if ( index < 0 || index > size()) {
         throw new IndexOutOfBoundsException();
      }
      final Integer temp = array[index];
      array[index] = element;

      return temp;
   }

   // Remove the element of the given index. Return that element.

   public Integer remove(final int index) throws IndexOutOfBoundsException {
      if ( index < 0 || index > size()) {
         throw new IndexOutOfBoundsException();
      }

      final Integer temp = array[index];
      for(int x = index; x < this.array.length - 1; x++){
         array[x] = array[x + 1];
      }
      array[array.length-1] = null;

      return temp;
   }


   // Remove the element by its name. Return false if
   // the element it is not present.

   public boolean remove(final Integer element) {
      boolean present = false;
      int index = 0;
      for (Integer i : this.array){
         if (i.equals(element)){
            present = true;
            index++;
            break;
         }
         index++;
      }
      for(int x = index; x < this.array.length - 1; x++){
         array[x] = array[x + 1];
      }
      if (present){ 
      array[array.length-1] = null;
      }
      
      return present;
   }

   // Return the size of the array.
   public int size(){
      return this.size;
   }

   // Set all values of the array to null to clear it
   public void clear() {
      for (int i = 0; i < this.array.length; i++) {
         set(i, null);
      }
   }


   public static void main (final String[] args) throws IndexOutOfBoundsException {
      final Scanner input = new Scanner(System.in, "US-ASCII");
      final Integer[] y = {1,2,3,4,5,6,7,8,9,10};
/*
      // Testing size of constructor with parameter.
      final int x = input.nextInt();
      final MyArrayList f = new MyArrayList(x);
      System.out.println("---TESTING CONSTRUCTOR WITH PARAMETER AND SIZE--");
      System.out.println(f.size());

      // Testing size of constructor with no parameter.

      final MyArrayList s = new MyArrayList();
      System.out.println("---TESTING CONSTRUCTOR WITHOUT PARAMETER AND SIZE--");
      System.out.println(s.size());

      
      // Testing set()
      System.out.println("---TESTING CONSTRUCTOR SET---");
      
      for (int i = 0 ; i < s.size(); i++){
         s.set(i, y[i]);
      }
      
      for (int i = 0; i < s.size(); i++){
         System.out.println(s.get(i));
      }


      // Testing add(), ensureCapacity() and size().
      System.out.println("---TESTING CONSTRUCTOR ADD, ENSURECAPACITY AND SIZE--");
      System.out.println("Initial Size: " + s.size());
      Integer b = 15;
      Integer n = 68;
      System.out.println(s.add(n));
      System.out.println(s.add(b));
      for (int i = 0; i < s.size(); i++){
         System.out.println(s.get(i));
      }
      System.out.println("Final Size: " + s.size());


      
      // Testing set()
      System.out.println("---TESTING CONSTRUCTOR SET---");
      for (int i = 0 ; i < s.size(); i++){
         s.set(i, y[i]);
      }
      
      for (int i = 0; i < s.size(); i++){
         System.out.println(s.get(i));
      }


      // Testing get()
      System.out.println("---TESTING GET---");
      for (int i = 0; i < s.size(); i++){
         System.out.println(s.get(i));
      }

      // Testing remove() with index
      System.out.println("---TESTING REMOVE WITH INDEX---");
      System.out.println("removed: " + f.remove(2));
      for (int i = 0; i < s.size(); i++){
         System.out.println(s.get(i));
      }
      

      // Testing remove() with object
      System.out.println("--TESTING REMOVE WITH OBJECT---");
      Integer k = 6;
      System.out.println("Removed: " + f.remove(k));
      for (int i = 0; i < s.size(); i++){
         System.out.println(s.get(i));
      }

      // Testing clear()
      System.out.println("---TESTING CLEAR---");
      s.clear();
      for (int i = 0; i < s.size(); i++){
         System.out.println(s.get(i));
      }
      

      */

   }

}
