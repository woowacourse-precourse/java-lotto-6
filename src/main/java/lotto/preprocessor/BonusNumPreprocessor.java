package lotto.preprocessor;

import java.util.List;
import lotto.util.ExceptionHandler;
import lotto.util.LottoConst;

public class BonusNumPreprocessor extends Preprocessor<Integer> {

    List<Integer> winningNumbers;

    @Override
    public boolean isInvalid(String userInput) {
        return !(isNumber(userInput)
                && isValidBonusNumRange(convert(userInput))
                && isNotDuplicated(convert(userInput)));
    }

    @Override
    public Integer convert(String userInput) {
        return Integer.parseInt(userInput);
    }

    private static boolean isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            ExceptionHandler.handleException("보너스 번호로 숫자를 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }

    private boolean isValidBonusNumRange(int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            ExceptionHandler.handleException("보너스 번호는 "
                    + LottoConst.FIRST_NUM
                    + "~"
                    + LottoConst.LAST_NUM
                    + " 사이의 숫자로 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }

    private boolean isNotDuplicated(int bonusNum) {
        if (winningNumbers.contains(bonusNum)) {
            ExceptionHandler.handleException("당첨 번호와 중복되지 않는 숫자를 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
}
