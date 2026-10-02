package Array.task6;
public class Main{

    public static int[] moveZeroes(int[] nums) {
        int i = 0;
        int k = 0;
        while(i != nums.length){
            if(nums[i] != 0){
                nums[k] = nums[i];
                k += 1;
            }
            i += 1;
        }
        for(;k < i; k++){
            nums[k] = 0;
        }
        return nums;
    }
    public static void main(String[] args){
        System.out.println("Hello, World!");

        int[] inputArray = new int[]{0,1,0,3,12};
        
        var answer = moveZeroes(inputArray);
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");  
        }

    }

    
}