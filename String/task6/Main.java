package String.task6;

import java.util.HashMap;

public class Main {
    
    public static void main(String[] args){
        String test = "aba";
        System.out.println(Solution(test));
    }
    
    public static int Solution(String str){
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> indexRem = new HashMap<>();
        int answer = 0;
           while(i < str.length() && j < str.length()){
                int count = indexRem.getOrDefault(str.charAt(j), 0);
                
                if (count == 0){
                    answer += j - i + 1 ;
                    indexRem.put(str.charAt(j), count + 1);
                    j++;
                }else{
                    char current = str.charAt(i);
                    indexRem.put(str.charAt(i), indexRem.get(current) - 1);
                    i++;
                    
                }
           } 
           return answer;
    }


    
}
