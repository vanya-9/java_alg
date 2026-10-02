package String.task15;

public class Main{
    public static void main(String[] args){
        
    }

    public boolean isPalindrom(String str, int indexStart, int indexEnd){
        while(indexStart < indexEnd){
            if (str.charAt(indexStart) != str.charAt(indexEnd)){
                return false;
            }
            indexStart++;
            indexEnd--;
        }
        return true;
    }

    public boolean Solution(String str1){
        int indexStart = 0;
        int indexEnd = str1.length() - 1;
        while(indexStart < indexEnd){
            if (str1.charAt(indexStart) != str1.charAt(indexEnd)){
               if (isPalindrom(str1, indexStart + 1, indexEnd)){
                return true;
               }
               if (isPalindrom(str1, indexStart, indexEnd - 1)){
                return true;
               }
               
               return false;
            }
            indexStart++;
            indexEnd--;
        }
        return true;
    }
}