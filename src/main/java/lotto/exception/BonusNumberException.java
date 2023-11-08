package lotto.exception;

import java.util.List;

public class BonusNumberException {
    private static final int BONUS_NUMBER_START = 1;
    private static final int BONUS_NUMBER_FINISH = 45;
    private static final String IS_NUMBER_MESSAGE = " 보너스 숫자는 숫자를 입력해주셔야 합니다.";
    private static final String IS_RIGHT_RANGE_MESSAGE = " 보너스 숫자의 유효범위는 1부터 45까지 입니다.";
    private static final String IS_BLANK_MESSAGE = " 입력하신 보너스 숫자가 공백입니다.";
    private static final String IS_DUPLICATE_MESSAGE = " 입력하신 보너스 숫자가 당첨 번호와 중복인 숫자가 있습니다.";
    private static final String IS_ONLY_ONE_MESSAGE = " 보너스 숫자는 한 개만 입력해주세요";
    private static final String ERROR = "[ERROR]";

    public BonusNumberException(String input, List<Integer> winnerNum) {
        isNumber(input);
        isBlank(input);
        isNumberOnlyOne(input);
        isRightRange(input);
        isDuplicateWithWinnerNum(input, winnerNum);
    }

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + IS_NUMBER_MESSAGE);
        }
    }

    private void isRightRange(String input) {
        int bonusNum = Integer.parseInt(input);
        if (bonusNum < BONUS_NUMBER_START || bonusNum > BONUS_NUMBER_FINISH) {
            throw new IllegalArgumentException(ERROR + IS_RIGHT_RANGE_MESSAGE);
        }
    }

    private void isBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR + IS_BLANK_MESSAGE);
        }
    }

    private void isDuplicateWithWinnerNum(String bonusNumber, List<Integer> winnerNum) {
        int bonusNum = Integer.parseInt(bonusNumber);
        if (winnerNum.stream().anyMatch(i -> i == bonusNum)) {
            throw new IllegalArgumentException(ERROR + IS_DUPLICATE_MESSAGE);
        }
    }

    private void isNumberOnlyOne(String input) {
        if (input.split(",").length != 1) {
            throw new IllegalArgumentException(ERROR + IS_ONLY_ONE_MESSAGE);
        }
    }
}
