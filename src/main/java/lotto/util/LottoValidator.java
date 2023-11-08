package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String WRONG_PRICE = "1,000원으로 나눌 수 있는 금액을 입력하세요";
    private static final String WRONG_SIZE_NUMBER = "올바른 숫자 개수를 입력하고 중복 숫자를 주의해주세요";
    private static final String WRONG_NUMBER = "숫자를 넣어주세요";
    private static final String WRONG_NUMBER_RANGE = " 1~45 사이의 숫자를 입력하세요";

    private static final int DIVIDE_MONEY = 1_000;

    private static final int WINNING_NUMBER_LENGTH = 6;
    private static final int WINNING_NUMBER_LENGTH_PLUS_BONUS = 7;


    public static int divideMoney(String payMoney) {
        int money = checkNaturalNumber(payMoney);
        if (money != (money / DIVIDE_MONEY) * DIVIDE_MONEY) {
            exceptionFormat(WRONG_PRICE);
        }
        return money;
    }

    public static void checkWinningNumber(String[] rawNumbers) {
        Set<String> numbers = new HashSet<>(Arrays.asList(rawNumbers));

        checkLength(numbers.size(), WINNING_NUMBER_LENGTH);

        for (String number : numbers) {
            checkNumberRange(number);
        }
    }

    public static int checkBonusNumber(String bonusNumber, List<Integer> getWinningNumberWithBonusNumber) {
        int number = checkNumberRange(bonusNumber);

        Set<Integer> numbers = new HashSet<>(getWinningNumberWithBonusNumber);
        numbers.add(number);
        checkLength(numbers.size(), WINNING_NUMBER_LENGTH_PLUS_BONUS);

        return number;
    }

    private static int checkNumberRange(String bonusNumber) {
        int number = checkNaturalNumber(bonusNumber);
        if (number > 45) {
            exceptionFormat(WRONG_NUMBER_RANGE);
        }
        return number;
    }

    private static int checkNaturalNumber(String payMoney) {
        if (!payMoney.matches("^[1-9]\\d*$")) { // 자연수 정규식
            exceptionFormat(WRONG_NUMBER);
        }
        return Integer.parseInt(payMoney);
    }


    private static void checkLength(int length, int expectLength) {
        if (length != expectLength) {
            exceptionFormat(WRONG_SIZE_NUMBER);
        }
    }

    private static void exceptionFormat(String errorMessage) {
        throw new IllegalArgumentException(ERROR_MESSAGE + errorMessage);
    }
}
