package lotto.controller;

import lotto.utils.ExceptionMessage;
import lotto.utils.LottoUtil;

public class Money {
    private final int MIN_MONEY = 1000;
    private String inputMoney;
    private int count;

    public Money() {
        LottoUtil lottoUtil = new LottoUtil();
        boolean numberCheck = false;
        String payment = null;

        while (!numberCheck) {
            payment = lottoUtil.getUserInput();
            numberCheck = validateNumber(payment);
            if(numberCheck) {
                numberCheck = validateThousand(payment);
            }
        }

        setCount(payment);
        this.inputMoney = payment;
    }

    public String getInputMoney() {
        return this.inputMoney;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(String number) {
        this.count = Integer.parseInt(number) / MIN_MONEY;
    }

    public boolean validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.NUMBER.getValue());
            return false;
        }

        return true;
    }

    public boolean validateThousand(String number) {
        try {
            int convertNum = Integer.parseInt(number);
            if(convertNum % MIN_MONEY != 0 || convertNum < MIN_MONEY) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.THOUSAND.getValue());
            return false;
        }

        return true;
    }

}
