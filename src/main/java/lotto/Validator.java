package lotto;

public class Validator {

    public void isValidAmount(String amount) {
        String INVALID_AMOUNT = "[ERROR] 금액은 자연수를 입력하세요";
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_AMOUNT);
        }
        if (Integer.parseInt(amount) < 1) {
            throw new IllegalArgumentException(INVALID_AMOUNT);
        }
    }

    public void isAmountDivisibleBy1000(String amount) {
        String NOT_DIVISIBLE_BY_1000 = "[ERROR] 1000원으로 나누어떨어지는 금액을 입력하세요";
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_1000);
        }
    }

    public void isValidWinningNumber(String[] number) {
        String INVALID_NUMBER = "[ERROR] ";
        for (String num : number) {
            try {
                Integer.parseInt(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_NUMBER);
            }
        }
    }
}
