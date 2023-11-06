package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinnerLotto {

    private final List<Integer> winnerNumbers;
    private final Integer bonusNumber;

    public WinnerLotto(List<Integer> winnerNumbers, Integer bonusNumber) {
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }


    public List<Integer> getWinnerNumbers() {
        return Collections.unmodifiableList(winnerNumbers);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }


}
