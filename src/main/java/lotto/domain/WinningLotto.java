package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final List<WinningNumber> winningNumbers;

    private WinningLotto(List<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(List<WinningNumber> winningNumbers, WinningNumber bonusNum) {
        List<WinningNumber> resultNumbers = new ArrayList<>(winningNumbers);
        resultNumbers.add(bonusNum);
        return new WinningLotto(resultNumbers);
    }

}
