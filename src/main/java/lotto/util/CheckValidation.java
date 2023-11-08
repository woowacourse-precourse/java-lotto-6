package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.enums.Constant.MONEY_UNIT;
import static lotto.enums.Constant.NUMBER_FOR_INITIALIZATION;
import static lotto.enums.Message.*;
import static lotto.controller.InputController.*;

public class CheckValidation {
    public void checkInputMoneyUnit() {
        if (money % MONEY_UNIT.getValue() != NUMBER_FOR_INITIALIZATION.getValue()) {
            throw new IllegalArgumentException(CHECK_INPUT_MONEY_UNIT_MSG.getMessage());
        }
    }
    public void checkInputMoneyFigure(String stringMoney) {
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, stringMoney)) {
            throw new IllegalArgumentException(CHECK_INPUT_MONEY_FIGURE_MSG.getMessage());
        }
    }
    public void checkWinningNumBlank(String[] numberStrings) {
        boolean checkBlank = Arrays.stream(numberStrings).noneMatch(str -> str.equals(" "));
        if (!checkBlank) {
            throw new IllegalArgumentException(CHECK_WINNING_NUM_BLANK_MSG.getMessage());
        }
    }
    public void checkWinningNumDuplication() {
        List<Integer> checking = new ArrayList<>();
        checking = winningNumbers.stream().distinct().collect(Collectors.toList());

        if (winningNumbers.size() != checking.size()) {
            throw new IllegalArgumentException(CHECK_WINNING_NUM_DUPLICATION_MSG.getMessage());
        }
    }
    public void checkWinningNumRangeOver() {
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(CHECK_WINNING_NUM_RANGE_OVER_MSG.getMessage());
            }
        }
    }
    public void checkWinningNumAmount() {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(CHECK_WINNING_NUM_AMOUNT_MSG.getMessage());
        }
    }
    public void checkBonusNumDuplication() {
        for (Integer winningNum : winningNumbers) {
            if (bonusNumber == winningNum) {
                throw new IllegalArgumentException(CHECK_BONUS_NUM_DUPLICATION_MSG.getMessage());
            }
        }
    }
    public void checkBonusNumRangeOver() {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(CHECK_BONUS_NUM_RANGE_OVER_MSG.getMessage());
        }
    }
}
