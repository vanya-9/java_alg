package task14;

public class Main{

    public static StringBuilder solution(char[] str){
        StringBuilder result = new StringBuilder();
        int counter = 1;
        for(int i = 0; i < str.length - 1; i++){
            if (str[i] != str[i + 1]){
                if (counter == 1){
                    result.append(str[i]);
                }else{
                    result.append(counter);
                    result.append(str[i]);
                    counter = 1;
                }
            }else{
                counter++;
            }
        }
        if (counter == 1){
            result.append(str[str.length - 1]);
        }
        else {
            result.append(counter);
            result.append(str[str.length - 1]);
        }
        return result;
    }

    public static void main(String[] args){
        char[] testCase = {'A','A','A','B','C','C'};
        StringBuilder resultSolution = solution(testCase);

        System.out.println(resultSolution);;
    }

    
}