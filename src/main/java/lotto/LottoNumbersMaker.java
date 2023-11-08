package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersMaker {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
