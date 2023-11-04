package lotto.domain.lotto.strategy;

import java.util.List;

public interface PickNumbersStrategy {

    List<Integer> pickNumbers(int minValue, int maxValue, int count);

}
