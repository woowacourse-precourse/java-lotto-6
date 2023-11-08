package lotto.controller;

import lotto.utils.ExceptionMessage;
import lotto.utils.LottoUtil;

public class Money {
    private final int MIN_MONEY = 1000;
    private int inputMoney;
    private int count;

    public Money() {
        LottoUtil lottoUtil = new LottoUtil();
        String payment = null;

        payment = lottoUtil.getUserInput();
        validateNumber(payment);
        validateThousand(payment);

        setCount(payment);
        this.inputMoney = Integer.parseInt(payment);
    }

    public int getInputMoney() {
        return this.inputMoney;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(String number) {
        this.count = Integer.parseInt(number) / MIN_MONEY;
    }

    public void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER.getValue());
        }
    }

    public void validateThousand(String number) {
        try {
            int convertNum = Integer.parseInt(number);
            if(convertNum % MIN_MONEY != 0 || convertNum < MIN_MONEY) {
                throw new IllegalStateException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER.getValue());
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(ExceptionMessage.THOUSAND.getValue());
        }
    }

}
