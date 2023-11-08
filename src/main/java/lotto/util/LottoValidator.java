package lotto.util;

import java.util.HashSet;
import java.util.Set;

public class LottoValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String WRONG_PRICE = "1,000원으로 나눌 수 있는 금액을 입력하세요";
    private static final String WRONG_SIZE_NUMBER = "6자리 숫자를 넣어주세요";
    private static final String WRONG_NUMBER = "숫자를 넣어주세요";
    private static final String DUPLICATE_NUMBER = "중복된 숫자를 제거해주세요";

    private static final int DIVIDE_MONEY = 1_000;

    private static final int WINNING_NUMBER_LENGTH = 6;

    public static int divideMoney(String payMoney) {
        if (!payMoney.matches("^[1-9]\\d*$")) { // 자연수 정규식
            inputException();
        }
        int money = Integer.parseInt(payMoney);
        if (money != money / DIVIDE_MONEY * DIVIDE_MONEY) {
            inputException();
        }
        return money;
    }
    private static void inputException() {
        throw new IllegalArgumentException(ERROR_MESSAGE + WRONG_PRICE);
    }

    public static void checkWinningNumber(String[] rawNumbers) {
        Set<String> numbers = new HashSet<>();
        checkLength(rawNumbers.length, WRONG_SIZE_NUMBER);
        for (String number : rawNumbers) {
            if (!Character.isDigit(number.charAt(0))) {
                throw new IllegalArgumentException(ERROR_MESSAGE + WRONG_NUMBER);
            }
            checkNumber(number);
            numbers.add(number);
        }
        checkLength(numbers.size(), DUPLICATE_NUMBER);

    }

    private static void checkLength(int length, String errorMessage) {
        if (length != WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + errorMessage);
        }
    }

    public static int checkNumber(String bonusNumber) {
        if (!bonusNumber.matches("^[1-9]\\d*$")) { // 자연수 정규식
            inputException();
        }
        int number = Integer.parseInt(bonusNumber);
        if (number > 45) {
            inputException();
        }
        return number;
    }
}
