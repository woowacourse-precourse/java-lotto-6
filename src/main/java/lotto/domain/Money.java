package lotto.domain;

import lotto.utils.InputValidator;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(String inputMoney) {
        this.money = validateMoney(inputMoney);
    }

    private int validateMoney(String inputMoney) {
        InputValidator.validateEmpty(inputMoney);
        InputValidator.validateNull(inputMoney);
        return validateInteger(inputMoney);
    }


    private int validateInteger(String inputMoney) {
        int parsedMoney;
        try {
            parsedMoney = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능");
        }

        if (parsedMoney <= 0 || parsedMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위 양수만 가능");
        }
        return parsedMoney;
    }

    public int getMoney(){
        return this.money;
    }

    public int getLottoCount(){
        return money/1000;
    }
}
