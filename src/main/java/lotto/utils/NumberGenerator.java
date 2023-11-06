package lotto.utils;

import java.util.List;

public interface NumberGenerator {

    List<Integer> generateNumbers(int start, int end, int count);
}
