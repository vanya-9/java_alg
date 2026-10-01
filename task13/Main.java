package task13;

public class Main{
    public static void main(String[] args){

    }

    public static boolean fuzzySearch(String str, String substring){
        if (str == null || substring == null){
            return false;
        }
        
        int i = 0;
        int j = 0;
        while(i < str.length() && j < substring.length()){
            if (str.charAt(i) == substring.charAt(j)){
                j++;
            }
            i++;
        }


        return j == substring.length();
    }
}