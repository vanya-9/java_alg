package task7;

public class Main {
    
}


// public int findPermutationSimple(String text, String pattern) {
//     if (text.length() < pattern.length()) return -1;

//     Map<Character, Integer> mapS = new HashMap<>();
//     Map<Character, Integer> mapT = new HashMap<>();

//     // 1. Заполняем эталонный словарь
//     for (char c : pattern.toCharArray()) {
//         mapS.put(c, mapS.getOrDefault(c, 0) + 1);
//     }

//     int left = 0;
//     for (int right = 0; right < text.length(); right++) {
//         // Добавляем символ в окно
//         char cRight = text.charAt(right);
//         mapT.put(cRight, mapT.getOrDefault(cRight, 0) + 1);

//         // Если окно стало больше нужного, сдвигаем левую границу
//         if (right >= pattern.length()) {
//             char cLeft = text.charAt(left);
//             mapT.put(cLeft, mapT.get(cLeft) - 1);
//             if (mapT.get(cLeft) == 0) mapT.remove(cLeft); // чистим нули
//             left++;
//         }

//         // Когда окно достигло размера pattern, проверяем совпадение
//         if (right >= pattern.length() - 1) {
//             if (isMapsEqual(mapS, mapT)) {
//                 return left;
//             }
//         }
//     }
//     return -1;
// }

// // Вспомогательный метод для сравнения (тот самый "тяжелый" шаг)
// private boolean isMapsEqual(Map<Character, Integer> m1, Map<Character, Integer> m2) {
//     if (m1.size() != m2.size()) return false;
//     for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
//         if (!m2.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
//             return false;
//         }
//     }
//     return true;
// }