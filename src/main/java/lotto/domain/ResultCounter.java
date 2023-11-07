package lotto.domain;

import java.util.List;

public class ResultCounter implements Counter {
    @Override
    public int counter(int target) {
        return 0;
    }

    @Override
    public int counter(List<Integer> numbers, List<Integer> winnerNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winnerNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
