class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];  // Массив для хранения первых n "уродливых" чисел
        uglyNumbers[0] = 1;  // Первое "уродливое" число — 1

        int i2 = 0, i3 = 0, i5 = 0;  // Индексы для множителей 2, 3 и 5
        int nextMultipleOf2 = 2;  // Следующее число, кратное 2
        int nextMultipleOf3 = 3;  // Следующее число, кратное 3
        int nextMultipleOf5 = 5;  // Следующее число, кратное 5

        for (int i = 1; i < n; i++) {
            // Следующее "уродливое" число — это минимальное среди nextMultipleOf2, nextMultipleOf3 и nextMultipleOf5
            int nextUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUglyNumber;  // Сохраняем найденное число

            // Обновляем множители для 2, 3 и 5, если nextUglyNumber равно их значению
            if (nextUglyNumber == nextMultipleOf2) {
                i2++;  // Увеличиваем индекс для множителя 2
                nextMultipleOf2 = uglyNumbers[i2] * 2;  // Обновляем следующее кратное 2
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3++;  // Увеличиваем индекс для множителя 3
                nextMultipleOf3 = uglyNumbers[i3] * 3;  // Обновляем следующее кратное 3
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5++;  // Увеличиваем индекс для множителя 5
                nextMultipleOf5 = uglyNumbers[i5] * 5;  // Обновляем следующее кратное 5
            }
        }

        return uglyNumbers[n - 1];  // Возвращаем n-е "уродливое" число
    }
}