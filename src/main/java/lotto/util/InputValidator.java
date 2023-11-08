package lotto.util;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public boolean isValidInputMoney(String userInput) {
        try {
            int inputMoney = Integer.parseInt(userInput);
            if (inputMoney % 1000 != 0) {
                throw new IllegalArgumentException(Message.INPUT_INSERT_MONEY_THOUSAND_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            OutputView.printInputNotNumberErrorMessage();
            return false;
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isValidInteger(String[] splitUserInput) {
        for (String sNum : splitUserInput) {
            try {
                Integer.parseInt(sNum);
            } catch (NumberFormatException e) {
                OutputView.printInputNumRangeErrorMessage();
                return false;
            }
        }
        return true;
    }

    public void isNotDuplicated(String[] splitUserInput) {
        List<Integer> inputDangchum = new ArrayList<>();
        for (String sNum : splitUserInput) {
            int iNum = Integer.parseInt(sNum);
            if (inputDangchum.contains(iNum)) {
                throw new IllegalArgumentException(Message.DUPLICATE_MESSAGE);
            }
            if (iNum < Constant.LOTTO_MIN_NUM || iNum > Constant.LOTTO_MAX_NUM) {
                throw new IllegalStateException(Message.INPUT_NUM_RANGE_ERROR_MESSAGE);
            }
            inputDangchum.add(iNum);
        }
    }
}
