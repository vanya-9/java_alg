package Array.task2;

public class Solution {
    public int[] findMaxMonotonic(int[] a) {
        if (a == null || a.length == 0) return new int[]{-1, -1};
        if (a.length == 1) return new int[]{0, 0};

        // 2. Стартовые значения для первого элемента (индекс 0)
        int curInc = 1;
        int curDec = 1;
        
        int startInc = 0; // Индекс начала текущего возрастающего отрезка
        int startDec = 0; // Индекс начала текущего убывающего отрезка

        int maxLen = 1;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                curInc++;
                curDec = 1;      
                startDec = i;   
            } 
            else if (a[i] < a[i - 1]) {
                curDec++;
                curInc = 1;
                startInc = i;
            } 
            else {
                curInc = 1;     
                curDec = 1;
                startInc = i;
                startDec = i;
            }

            if (curInc > maxLen) {
                maxLen = curInc;
                bestStart = startInc;
                bestEnd = i;
            }
            if (curDec > maxLen) {
                maxLen = curDec;
                bestStart = startDec;
                bestEnd = i;
            }
        }

        return new int[]{bestStart, bestEnd};
    }
}