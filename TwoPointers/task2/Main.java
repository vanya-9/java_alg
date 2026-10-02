package TwoPointers.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<Integer> solution(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        
        // 1. Основной цикл слияния/фильтрации
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                // Элемента точно нет во втором массиве
                result.add(arr1[p1]);
                p1++;
            } else if (arr1[p1] > arr2[p2]) {
                // Элемент из arr2 слишком мал, пропускаем его
                p2++;
            } else {
                // arr1[p1] == arr2[p2] — нашли совпадение!
                int val = arr1[p1];
                
                // Пропускаем ВСЕ дубли этого значения в arr1
                while (p1 < arr1.length && arr1[p1] == val) {
                    p1++;
                }
                // Пропускаем ВСЕ дубли этого значения в arr2
                while (p2 < arr2.length && arr2[p2] == val) {
                    p2++;
                }
            }
        }
        
        // 2. КРИТИЧЕСКИ ВАЖНО: Выводим «хвост» из arr1, если arr2 закончился
        while (p1 < arr1.length) {
            result.add(arr1[p1]);
            p1++;
        }
        
        return result;
    }
}