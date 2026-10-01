package task4;

public class Main{

    public int decision(int[] nums){
        if (nums == null){
            throw new IllegalArgumentException("Input array is null");
        }

        int counter = 0;
        int maxCounter = 0;
        for(int numb : nums){
            if (numb == 1){
                counter += 1;

                if (counter > maxCounter){
                    maxCounter = counter;
                }
            }
            else{
                counter = 0;
            }
            
        }

        return maxCounter;
    }
    public static void main(String[] args){
        int[] nums = new int[]{};
        Main m = new Main();
        System.out.println(m.decision(nums));
    }
}