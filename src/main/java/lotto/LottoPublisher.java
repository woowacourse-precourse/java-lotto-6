package lotto;

import static lotto.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.Lotto.MAX_BOUND;
import static lotto.Lotto.MIN_BOUND;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.common.CustomArgumentException;
import lotto.generator.NumberGenerator;

public class LottoPublisher {
    private final NumberGenerator numberGenerator;

    public LottoPublisher(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public LottoBundle publishBundle(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = publish();
            lottos.add(lotto);
        }

        return new LottoBundle(lottos);
    }

    private Lotto publish() {
        List<Integer> numbers = generateNumbers();
        while (true) {
            try {
                return new Lotto(numbers);
            } catch (CustomArgumentException ignored) {
                numbers = generateNumbers();
            }
        }
    }

    private List<Integer> generateNumbers() {
        return numberGenerator.generate(MIN_BOUND, MAX_BOUND, LOTTO_NUMBERS_SIZE);
    }
}
