package lotto.validation;

import lotto.config.ErrorMessage;
import lotto.config.ConstNum;
import lotto.view.OutputView;

import java.util.ArrayList;

public class WinningNumValidator {

    static public void validate(ArrayList<Integer> winningNum) {
        lengthValidate(winningNum);
        duplicatedValidate(winningNum);
        numberRangeValidate(winningNum);
    }

    static public void bonusValidate(ArrayList<Integer> winningNum,Integer number) {
        duplicatedValidate(winningNum,number);
        rangeValidate(number);
    }

    private static void lengthValidate(ArrayList<Integer> winningNum) {
        if (winningNum.size() != ConstNum.LENGTH.getNum()) {
            OutputView.errorMessage(ErrorMessage.LENGTH_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private static void duplicatedValidate(ArrayList<Integer> winningNum) {
        long count = winningNum.stream()
                .distinct()
                .count();

        if (count != ConstNum.LENGTH.getNum()) {
            OutputView.errorMessage(ErrorMessage.DUPLICATED_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private static void duplicatedValidate(ArrayList<Integer> winningNum,Integer bonusNumber) {
        if (winningNum.contains(bonusNumber)) {
            OutputView.errorMessage(ErrorMessage.BONUS_DUPLICATED_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }

    private static void numberRangeValidate(ArrayList<Integer> winningNum) {
        for (Integer num : winningNum) {
            rangeValidate(num);
        }
    }

    private static void rangeValidate(Integer number) {
        if (number > ConstNum.LOTTO_MAX.getNum() || number < ConstNum.LOTTO_MIN.getNum()) {
            OutputView.errorMessage(ErrorMessage.RANGE_ERROR.getMessage());

            throw new IllegalArgumentException();
        }
    }
}
