package task7;

import java.util.HashMap;
import java.util.Map;

public class BestDecision {
    public int findPermutationOptimized(String text, String pattern){
        if (text == null || pattern == null || text.length() < pattern.length()) {
            return -1;
        }

        if (pattern.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> diff = new HashMap<>();
        int diffCount = 0;

        //проходимся по паттерну, если в diff нет символа, то увеличиваем diffCount - кол-во недостающих символов
        // Если символ есть, то увеличиваем значение в мапе на единицу и все
        for(char c : pattern.toCharArray()){
            int count = diff.getOrDefault(c, 0);
            if (count == 0) {
                diffCount++;
            }
            diff.put(c, count + 1);
        }

        int left = 0;
        for(int right = 0; right < text.length(); right++){
            char cRight = text.charAt(right);

            // 2. Впускаем символ в окно (уменьшаем его "нехватку" на 1)
            int countRight = diff.getOrDefault(cRight, 0);
            if (countRight == 0) {
                diffCount++;      // Было 0, стало -1 (появился лишний символ)
            } else if (countRight == 1) {
                diffCount--;      // Было 1, стало 0 (символ полностью сбалансирован!)
            }
            diff.put(cRight, countRight - 1);

            // 3. Если окно стало больше нужного, выпускаем левый символ
            while (right - left >= pattern.length()) {
                char cLeft = text.charAt(left);
                int countLeft = diff.getOrDefault(cLeft, 0);

                if (countLeft == 0) {
                    diffCount++;      // Было 0, стало 1 (снова не хватает этого символа)
                } else if (countLeft == -1) {
                    diffCount--;      // Было -1, стало 0 (убрали лишний символ, баланс восстановлен)
                }
                diff.put(cLeft, countLeft + 1);
                left++;
            }

            // 4. Проверяем: если окно нужного размера и все символы сбалансированы
            if (right - left + 1 == pattern.length() && diffCount == 0) {
                return left;
            }
        }

        return -1;
    }
}


// Вот как бы общая идея:
// ипо я создаю мапу дифов - идея в следующем, посчитаем символы в паттерне. Они все 
// положительные, их нам надо добрать.
// Когда я начинаю добирать, могут попасться символы лишние, такие я добавлю в дифф с 
// отрицательным значением. Но их тоже нужно будет выкинуть, поэтому diffCount я увеличу.