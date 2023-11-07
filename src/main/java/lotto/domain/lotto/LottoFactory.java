package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.domain.NumberGenerator;
import lotto.domain.lotto.Lotto;

public class LottoFactory {
    public static Lotto createLotto() {
        final List<Integer> numbers = NumberGenerator.generateRandomNumbers();
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
