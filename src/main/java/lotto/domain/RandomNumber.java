package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class RandomNumber {
    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        sortRandomNumbers(randomNumbers);

        return randomNumbers;
    }

    private void sortRandomNumbers(List<Integer> randomNumbers) {
        randomNumbers.sort(Comparator.naturalOrder());
    }
}
