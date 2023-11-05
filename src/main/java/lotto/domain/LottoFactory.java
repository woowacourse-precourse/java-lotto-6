package lotto.domain;

import java.util.List;

public class LottoFactory {
    public static Lotto createLotto() {
        final List<Integer> numbers = NumberGenerator.generateRandomNumbers();

        return new Lotto(numbers);
    }
}
