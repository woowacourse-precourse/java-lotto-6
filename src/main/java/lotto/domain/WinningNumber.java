package lotto.domain;

import lotto.Lotto;

import java.util.List;

import static lotto.constant.LottoErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;

public class WinningNumber extends Lotto {
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        super(winningNumber);
        validate(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void validate(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
