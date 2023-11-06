package lotto;

import java.util.ArrayList;
import java.util.List;

public class Print {

    List<Integer> sort(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        numbers.sort(null);
        return numbers;
    }
}
