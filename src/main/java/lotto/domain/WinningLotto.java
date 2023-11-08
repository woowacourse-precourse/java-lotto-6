package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<WinningNumber> winningNumbers;

    private WinningLotto(List<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto of(List<WinningNumber> winningNumbers) {
        return new WinningLotto(winningNumbers);
    }

}
