package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = (int) (Math.random() * 45) + 1;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
