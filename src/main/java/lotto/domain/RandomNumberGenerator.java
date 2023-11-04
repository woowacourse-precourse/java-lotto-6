package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.NumberConstraints.*;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        Set<Integer> numbersSet = new HashSet<>();
        while (numbersSet.size() < LOTTO_PER_NUMBER.value()) {
            int number = Randoms.pickNumberInRange(LOTTO_MIN_NUMBER.value(), LOTTO_MAX_NUMBER.value());
            numbersSet.add(number);
        }
        return numbersSet.stream().sorted().toList();
    }
}
