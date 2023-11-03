package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static lotto.domain.constants.LottoConstraint.LOTTO_PICK_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto() {
        Set<Integer> pickedNumbers = new TreeSet<>();
        while (LOTTO_PICK_COUNT.isSmaller(pickedNumbers.size())) {
            int randomNumber = RandomNumberGenerator.generateLottoNumber();
            pickedNumbers.add(randomNumber);
        }
        numbers = pickedNumbers.stream().toList();
    }

    public static Lotto create() {
        return new Lotto();
    }
}
