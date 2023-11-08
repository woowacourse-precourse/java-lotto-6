package lotto.view;

import lotto.domain.LottoRole;

import static lotto.view.ErrorMessageContainer.*;

import java.util.ArrayList;
import java.util.List;

public class InputMaker {

    public int inputNum(String userInput) {
        try {
            return Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALID_NUMBER.getMessage());
        }
    }

    public void inputCoinValidate(int coin) {
        if (coin % 1000 != 0) {
            throw new IllegalArgumentException(NOT_VALID_INPUT_FOR_COIN.getMessage());
        }
    }

    public void lottoNumRangeValidate(int num) {
        if (num < LottoRole.LOTTO_MIN_NUMBER.getNumber() ||
                num > LottoRole.LOTTO_MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(NOT_VALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> inputWinningNumber(String userInput) {
        List<Integer> result = new ArrayList<>();
        String[] inputNumber = userInput.split(",");
        for (int i = 0; i < inputNumber.length; i++) {
            int nowNum = inputNum(inputNumber[i].trim());
            lottoNumRangeValidate(nowNum);
            result.add(nowNum);
        }
        return result;
    }
}
