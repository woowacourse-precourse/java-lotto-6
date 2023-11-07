package lotto.generator;

import static lotto.Option.GameOption.LOTTO_MAX_NUMBER;
import static lotto.Option.GameOption.LOTTO_MIN_NUMBER;
import static lotto.Option.GameOption.LOTTO_NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> create() {
        return ascendOrder(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getNumber(),
                LOTTO_MAX_NUMBER.getNumber(), LOTTO_NUMBER_LENGTH.getNumber()));
    }

    private List<Integer> ascendOrder(List<Integer> randomNumbers) {
        return randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
