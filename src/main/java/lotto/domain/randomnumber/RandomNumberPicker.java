package lotto.domain.randomnumber;

import java.util.List;

public interface RandomNumberPicker {

    List<Integer> pickSixNumbersWithNotDuplicated(int startInclusive, int endInclusive);

}
