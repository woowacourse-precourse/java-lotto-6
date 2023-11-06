package lotto.domain;

import lotto.validator.WinningValidator;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers) {
        WinningValidator.validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return List.copyOf(winningNumbers);
    }
}
