package lotto.utils;

import java.util.List;

public interface NumberGenerator {
    int MIN_NUM = 1;
    int MAX_NUM = 45;
    int RANGE = 6;

    List<Integer> generateNumber();
}
