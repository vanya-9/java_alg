package HashTable.task2;

import java.util.HashMap;

public class Main {
    
    public void main(String[] args){

    }

    public void removeExtraOccurrences(int[] arr, int n){
        HashMap<Integer, Integer> Counter = new HashMap<>();

        int index_insert = 0;
        for(int i = 0; i < arr.length; i++){
            int countNow = Counter.getOrDefault(arr[i], 0);
            if (countNow < n){
                arr[index_insert] = arr[i];
                Counter.put(arr[i], countNow + 1);
                index_insert++;
            }
        }
    }
}
