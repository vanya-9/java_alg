package String.task2;

public class Main {
    public static void main(String[] args){

    }

    public static void solution(char[] chars, int trueLength){
        int counterSpace = 0;
        for (int i = 0; i < trueLength; i++){
            if (chars[i] == ' '){
                counterSpace++;
            }
        }

        int writeIndex = trueLength + (counterSpace * 2) - 1;
        for(int index = trueLength - 1; index >= 0; index--){
            if(chars[index] == ' '){
                chars[writeIndex] = '0';
                chars[writeIndex - 1] = '2';
                chars[writeIndex - 2] = '%';
                writeIndex -= 3;
            } else{
                chars[writeIndex] = chars[index];
                writeIndex--;
            }
        }
    }
}
