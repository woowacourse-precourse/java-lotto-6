package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.NumberConstraints.*;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.value(), LOTTO_MAX_NUMBER.value(), LOTTO_PER_NUMBER.value());
        return numbers.stream().sorted().toList();
    }
}
