package lotto.random;

import java.util.List;

public interface RandomNumberGenerator {
    List<Integer> pickUniqueNumbersInRange(int min, int max, int count);
}