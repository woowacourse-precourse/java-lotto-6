package lotto.domain;

import lotto.constant.ErrorMessages;
import lotto.constant.NumberConstants;
import lotto.util.Util;
import lotto.validation.InputValidator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumberConstants.*;

public class WinningNumbers {

    private final List<Integer> winning = new ArrayList<>();

    public List<Integer> createWinningNumber() {
        String winningNumber = InputView.WinningNumber();
        String[] parseNumbers = Util.parse(winningNumber);
        InputValidator.isNumeric(parseNumbers);
        List<Integer> winningNumbers = Util.stringToInt(parseNumbers);
        pickSixNumber(winningNumbers);
        checkNumberRange(winningNumbers);
        checkDuplicate(winningNumbers);
        winning.addAll(winningNumbers);
        return winning;
    }

    public List<Integer> createBonusNumber() {
        String bonusNumber = InputView.BonusNumber();
        List<Integer> bonusNumbers = new ArrayList<>();
        InputValidator.isNumeric(bonusNumber);
        containWinningNumber(bonusNumber);
        bonusNumbers.add(Integer.parseInt(bonusNumber));
        checkNumberRange(bonusNumbers);
        checkDuplicate(bonusNumbers);
        winning.addAll(bonusNumbers);
        return winning;
    }

    private void containWinningNumber(String bonusNumber) {
        if (winning.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static void checkDuplicate(List<Integer> winningNumbers) {
        if (InputValidator.isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static void checkNumberRange(List<Integer> winningNumbers) {
        if (!InputValidator.isInRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_RANGE.format(String.valueOf(LOTTO_NUMBER_MIN_RANGE.getValue()),
                            String.valueOf(LOTTO_NUMBER_MAX_RANGE.getValue())) +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static void pickSixNumber(List<Integer> winningNumbers) {
        if (!InputValidator.isSixNumber(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_COUNT.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }
}
