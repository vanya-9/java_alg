package Array.task5;

public class Main {

    public static void main(String[] args){
        int[] test = {10, 3, 1, 1};

        System.out.println(minCost(test));
    }

    public static int minCost(int[] arr){

        if (arr.length < 3){
            return -1;
        }

        int min1 = 1000000;
        int ind1 = 0;

        int min2 = 1000000;

        for (int i = 1; i < arr.length; i++){
            if (min1 > arr[i]){
                min2 = min1;

                min1 = arr[i];
                ind1 = i;
            }

            if (min2 > arr[i] && ind1 != i){
                min2 = arr[i];
            }
        }

        return arr[0] + min1 + min2;



    }
}
