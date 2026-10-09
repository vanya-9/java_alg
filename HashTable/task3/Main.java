package HashTable.task3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static int[] countCommonUnique(int[] a, int[] b){
       if (a.length != b.length){
        throw new IllegalArgumentException("Массивы разной длины");
       }

       int n = a.length;
       int[] result = new int[n];
       Set<Integer> setA = new HashSet<>();
       Set<Integer> setB = new HashSet<>();
       int currentIntersection = 0;

       for(int i = 0; i < n; i++){
            if (setA.add(a[i]) && setB.contains(a[i])){
                currentIntersection++;
            }

            if (setB.add(b[i]) && setA.contains(b[i])) {
                currentIntersection++;
            }

            result[i] = currentIntersection;
       }


        return result;
    }
    
    public static int[] countCommonWithMultiplicity(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Массивы должны быть одной длины");
        }

        int n = a.length;
        int[] result = new int[n];
        Map<Integer, Integer> countA = new HashMap<>();
        Map<Integer, Integer> countB = new HashMap<>();
        int currentIntersection = 0;

        for(int i = 0; i < n; i++){
            int newCountA = countA.getOrDefault(a[i], 0) + 1;
            countA.put(a[i], newCountA);

            // Если новая частота в A стала меньше или равна частоте в B, 
            // значит мы "нагнали" количество, и пересечение выросло на 1
            if (newCountA <= countB.getOrDefault(a[i], 0)) {
                currentIntersection++;
            }

            int newCountB = countB.getOrDefault(b[i], 0) + 1;
            countB.put(b[i], newCountB);

            if (newCountB <= countA.getOrDefault(b[i], 0)){
                currentIntersection++;
            }

            result[i] = currentIntersection;
        }

        return result;
    }
    public static void main(String[] args){

    }
}
