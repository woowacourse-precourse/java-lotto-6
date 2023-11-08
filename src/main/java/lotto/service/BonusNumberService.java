package lotto.service;

import lotto.exception.BonusNumberException;
import lotto.view.InputView;

import java.util.List;

public class BonusNumberService {

    public int getBonusNumber(List<Integer> winningNumbers) {
        InputView.promptBonusNumber();

        while (true) {
            try {
                return parseAndValidateBonusNumber(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseAndValidateBonusNumber(List<Integer> winningNumbers) {
        String bonusNumberStr = InputView.readBonusNumber();
        validateBonusNumberFormat(bonusNumberStr);

        int bonusNumber = Integer.parseInt(bonusNumberStr);
        validateBoundaryAndDuplicateBonusNumber(bonusNumber, winningNumbers);

        return bonusNumber;
    }

    private void validateBonusNumberFormat(String input) {
        BonusNumberException.ensureValidFormat(input);
    }

    private void validateBoundaryAndDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        BonusNumberException.ensureWithinValidRange(bonusNumber);
        BonusNumberException.ensureNotDuplicatedWithWinningNumbers(winningNumbers, bonusNumber);
    }
}
