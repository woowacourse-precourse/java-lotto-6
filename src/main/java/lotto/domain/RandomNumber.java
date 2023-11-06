package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNumber {
    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        return randomNumbers;
    }
}
