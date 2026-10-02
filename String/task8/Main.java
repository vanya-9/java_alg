package String.task8;

public class Main {
    public static void main(String[] args) {
        // Тесты из PDF
        System.out.println(solution("yy"));             // 0
        System.out.println(solution("xx"));             // 0
        System.out.println(solution("xy"));             // 1
        System.out.println(solution("yox"));            // 2
        System.out.println(solution("oooXOOYoxO"));     // 2
        System.out.println(solution("oooXXoY"));        // 2
    }

    public static int solution(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int indexX = -1;
        int indexY = -1;
        int minDst = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == 'x' || c == 'X') {
                indexX = i;
                if (indexY != -1) {
                    minDst = Math.min(minDst, Math.abs(indexX - indexY));
                }
            } 
            else if (c == 'y' || c == 'Y') {
                indexY = i;
                if (indexX != -1) {
                    minDst = Math.min(minDst, Math.abs(indexX - indexY));
                }
            }
        }

        return minDst == Integer.MAX_VALUE ? 0 : minDst;
    }
}