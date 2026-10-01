package task11;

public class Main{

    public static void main(String[] args){
        System.out.println(solution("fed", "13")); // 1000
    }

    public static boolean isSymbol(char symbol){
        return symbol >= 'a' && symbol <= 'f';
    }

    public static int symbolToChar(char symbol){
        return symbol - 'a' + 10;                 // ПРАВКА 1: было 'a' - symbol + 10
    }

    public static char digitToHex(int d){         // ДОБАВЛЕНО: без этого hex-символ не получить
        return d < 10 ? (char)('0' + d) : (char)('a' + d - 10);
    }

    public static String solution(String l, String m){   // ПРАВКА 2: void -> String
        int maxLen = Math.max(l.length(), m.length()) + 1;

        char[] result = new char[maxLen];
        for(int i = 0; i < maxLen; i++){
            result[i] = '-';
        }

        int lIndex = l.length() - 1;
        int mIndex = m.length() - 1;
        int posInsert = maxLen - 1;
        int nextRaz = 0;
        int sum = 0;
        while(lIndex >= 0 || mIndex >= 0 || nextRaz > 0){   // ПРАВКА 3: условие цикла
            if (lIndex >= 0) {                              // ПРАВКА 4: защита от выхода за границу
                if (isSymbol(l.charAt(lIndex))){
                    sum += symbolToChar(l.charAt(lIndex));
                } else{
                    sum += l.charAt(lIndex) - '0';          // ПРАВКА 5: было (int)charAt
                }
            }

            if (mIndex >= 0) {                              // ПРАВКА 6: то же для m
                if (isSymbol(m.charAt(mIndex))){
                    sum += symbolToChar(m.charAt(mIndex));
                } else{
                    sum += m.charAt(mIndex) - '0';          // ПРАВКА 7
                }
            }
            sum += nextRaz;

            nextRaz = sum / 16;                             // ПРАВКА 8: было sum % 16
            result[posInsert] = digitToHex(sum % 16);       // ПРАВКА 9: было (char)(sum/2)
            posInsert--;
            lIndex--;
            mIndex--;
            sum = 0;
        }
        return new String(result, posInsert + 1, maxLen - posInsert - 1); // ПРАВКА 10
    }
}