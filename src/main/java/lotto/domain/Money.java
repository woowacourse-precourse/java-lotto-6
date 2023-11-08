package lotto.domain;

import static lotto.constants.Constants.LOTTO_PRICE;
import static lotto.constants.MessageConstants.INVALID_INPUT_ERROR;
import static lotto.constants.MessageConstants.NOT_INTEGER_ERROR;

import lotto.utils.InputValidator;

public class Money {
    private final int money;

    public Money(String inputMoney) {
        this.money = validateMoney(inputMoney);
    }

    private int validateMoney(String inputMoney) {
        InputValidator.validateNull(inputMoney);
        InputValidator.validateEmpty(inputMoney);
        return validateInteger(inputMoney);
    }


    private int validateInteger(String inputMoney) {
        int parsedMoney;
        try {
            parsedMoney = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR);
        }

        if (parsedMoney <= 0 || parsedMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        return parsedMoney;
    }

    public int getMoney() {
        return this.money;
    }

    public int getLottoCount() {
        return money / 1000;
    }
}
