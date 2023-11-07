package lotto.domain.lotto;

import java.util.List;
import lotto.domain.NumberGenerator;

public class LottoFactory {
    public static Lotto createLotto() {
        final List<Integer> numbers = NumberGenerator.generateRandomNumbers();

        return new Lotto(numbers);
    }
}
