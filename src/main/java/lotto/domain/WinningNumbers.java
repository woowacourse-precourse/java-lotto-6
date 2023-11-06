package lotto.domain;

import lotto.validation.Validation;

import java.util.List;

import static lotto.util.LottoConstants.*;

public class WinningNumbers {

    private int bonusNumber;
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        Validation.validateSize(winningNumbers, LOTTO_NUMBERS_SIZE);
        Validation.validateDuplicationList(winningNumbers);
        Validation.validateDuplicateBonus(winningNumbers, bonusNumber);
        Validation.validateNumberListInRange(winningNumbers, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
    }

}
