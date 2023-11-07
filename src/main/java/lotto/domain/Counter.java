package lotto.domain;

import java.util.List;

public interface Counter {
    int counter(int target);

    int counter(List<Integer> numbers, List<Integer> winnerNumbers);
}
