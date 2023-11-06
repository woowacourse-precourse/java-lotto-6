package lotto.preprocessor;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ExceptionHandler;
import lotto.util.LottoConst;

public class PurchasePreprocessor extends Preprocessor<Integer> {

    @Override
    public boolean isInvalid(String userInput) {
        return !(isNumber(userInput)
                && isValidAmountUnit(convert(userInput))
                && isNaturalNumber(convert(userInput)));
    }

    @Override
    public Integer convert(String userInput) {
        return Integer.parseInt(userInput);
    }


    private static boolean isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            ExceptionHandler.handleException("구입 금액으로 숫자를 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }

    private static boolean isValidAmountUnit(int amount) {
        if ((amount % LottoConst.UNIT) != 0) {
            ExceptionHandler.handleException("구입 금액을 1,000원 단위로 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }

    private static boolean isNaturalNumber(int amount) {
        if (amount <= 0) {
            ExceptionHandler.handleException("구입 금액을 자연수로 입력해주세요.");
            return ExceptionHandler.EXCEPTION_OCCURED;
        }
        return ExceptionHandler.NO_EXCEPTION;
    }
}
