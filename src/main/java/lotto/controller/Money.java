package lotto.controller;

import lotto.utils.ExceptionMessage;
import lotto.utils.LottoUtil;

public class Money {
    private final int MIN_MONEY = 1000;
    private int inputMoney;
    private int count;
    private boolean isValidation;

    public Money() {
        LottoUtil lottoUtil = new LottoUtil();
        String payment = null;
        isValidation = false;
        while(!isValidation) {
            payment = lottoUtil.getUserInput();
            validateThousand(payment);
        }
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

    public void validateThousand(String number) {
        try {
            int convertNum = Integer.parseInt(number);
            if(convertNum % MIN_MONEY != 0) {
                throw new IllegalStateException();
            }
            isValidation = true;
        } catch (IllegalArgumentException e) {
            ExceptionMessage.NUMBER.printValue();
        } catch (IllegalStateException e) {
            ExceptionMessage.THOUSAND.printValue();
        }
    }

}
