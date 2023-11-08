package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Amount {
    private static final int standard_amount = 1000;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        amount = validateAmount();
        return amount / standard_amount;
    }
    private int validateAmount() {
        int amountNum;
        while(true) {
            try {
                amountNum = validateNumber(Console.readLine());
                validateNatural(amountNum);
                validateAmountindivisible(amountNum);
                break;
            }catch (IllegalArgumentException e) {
            }
        }
        return amountNum;
    }

    private int validateNumber(String input_amount) {
        try {
            return Integer.parseInt(input_amount);
        }catch (NumberFormatException e) {
            OutputError.error_not_number();
            throw new IllegalArgumentException();
        }
    }

    private void validateAmountindivisible(int amountNum) {
        if((amountNum % 1000) != 0) {
            OutputError.error_indivisible();
            throw new IllegalArgumentException();
        }
    }

    private void validateNatural(int amountNum) {
        if(amountNum <= 0) {
            OutputError.error_not_number();
            throw new IllegalArgumentException();
        }
    }

}
