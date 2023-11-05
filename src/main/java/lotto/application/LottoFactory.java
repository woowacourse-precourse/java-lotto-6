package lotto.application;

import static lotto.domain.LottoConfig.LOTTO_COUNT;
import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoFactory {
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        IntStream.rangeClosed(LOTTO_MIN_NUMBER.getValue(), LOTTO_MAX_NUMBER.getValue())
                .forEach(i -> LOTTO_NUMBER_CACHE.put(i, new LottoNumber(i)));
    }

    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto createLottoByAuto() {
        List<Integer> numbers = numberGenerator.generateNumbers(LOTTO_COUNT.getValue());
        return createLotto(numbers);
    }

    public Lotto createLottoByManual(List<Integer> numbers) {
        return createLotto(numbers);
    }

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LOTTO_NUMBER_CACHE::get)
                .toList()
        );
    }
}
