package lotto.model;

import java.util.List;
import lotto.validation.LottoNumberValidator;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return List.copyOf(winningNumbers);
    }

    private void validate(List<Integer> winningNumbers) {
        LottoNumberValidator.validateLottoNumber(winningNumbers);
    }
}
