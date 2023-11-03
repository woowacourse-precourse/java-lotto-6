package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    private WinningLotto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLotto getInstance(List<Integer> winningNumbers) {
        return new WinningLotto(winningNumbers);
    }
}
