package lotto.policy;

import java.util.List;

public interface LottoNumbersGenerator {
    int NUMBER_COUNT = 6;
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;

    List<Integer> generate();
}
