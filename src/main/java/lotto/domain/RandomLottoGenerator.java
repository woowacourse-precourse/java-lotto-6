package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constants.DomainConstants.*;

public class RandomLottoGenerator implements LottoGenerator {

    private RandomLottoGenerator() {
    }

    public static RandomLottoGenerator create() {
        return new RandomLottoGenerator();
    }

    @Override
    public Lotto generate() {
        return new Lotto(sortNumbers(getRandomNumbers()));
    }

    private List<Integer> sortNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(), LOTTO_NUMBER_COUNT.getValue());
    }
}
