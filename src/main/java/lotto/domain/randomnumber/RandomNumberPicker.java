package lotto.domain.randomnumber;

import java.util.List;

public interface RandomNumberPicker {

    List<Integer> pickSixUniqueNumbersInRange(int startInclusive, int endInclusive);

}
