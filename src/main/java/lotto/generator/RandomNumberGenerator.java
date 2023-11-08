package lotto.generator;

import static lotto.option.GameOption.LOTTO_MAX_NUMBER;
import static lotto.option.GameOption.LOTTO_MIN_NUMBER;
import static lotto.option.GameOption.LOTTO_NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> create() {
        return ascendOrder(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getNumber(),
                LOTTO_MAX_NUMBER.getNumber(), LOTTO_NUMBER_LENGTH.getNumber()));
    }

    public List<Integer> ascendOrder(List<Integer> randomNumbers) {
        return randomNumbers.stream()
                .sorted()
                .toList();
    }
}
