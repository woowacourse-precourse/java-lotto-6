package lotto.domain;

import lotto.error.ErrorMessage;

public class BonusNumber {
    private int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    public BonusNumber(String input) {
        int number = isNum(input);
        validate(number);
        this.number = number;

    }

    private void validate(int number) {
        isInRange(number);
    }

    private int isNum(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC);
        }
    }

    private void isInRange(int number) {
        if (number < Lotto.MIN_VALUE || number > Lotto.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
