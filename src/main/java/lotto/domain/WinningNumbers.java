package lotto.domain;

import lotto.validation.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    public static final int WINNING_NUMBERS_SIZE = 6;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MIN_NUMBER = 1;

    private int bonusNumber;
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        Validation.validateSize(winningNumbers, WINNING_NUMBERS_SIZE);
        Validation.validateDuplicationList(winningNumbers);
        Validation.validateDuplicateBonus(winningNumbers, bonusNumber);
        Validation.validateNumberListInRange(winningNumbers, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
    }

}
