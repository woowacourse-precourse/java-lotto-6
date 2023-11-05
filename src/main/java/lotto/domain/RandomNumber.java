package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomNumber {
    public List<Integer> generateRandomNumbers() {
        return new ArrayList<>();
    }

    private void sortRandomNumbers(List<Integer> randomNumbers) {
        randomNumbers.sort(Comparator.naturalOrder());
    }
}
