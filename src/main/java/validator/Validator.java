package validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final int TICKET_PRICE = 1000;
    private final int MAX_AMOUNT = 100000;
    private final int ZERO = 0;
    private final String ERROR_MESSAGE = "[ERROR] ";


    public void checkIsNumber(String input) throws IllegalArgumentException {
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자 형식이 아닙니다.");
        }
    }

    public void checkMinMoney(int input) throws IllegalArgumentException {
        if (input < TICKET_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "1000원 이상의 금액을 입력해 주세요.");
        }
    }

    public void checkMaxMoney(int input) throws IllegalArgumentException {
        if (input > MAX_AMOUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "100000원 이하의 금액을 입력해 주세요.");
        }
    }


    public void checkDividedByThousand(int amount) throws IllegalArgumentException {
        if (Math.floorMod(amount, TICKET_PRICE) != ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "1,000원의 단위로 입력해 주세요.");
        }
    }

    public void checkWinNumbersIsNumber(List<String> splitNumbers) throws IllegalArgumentException {
        for (String splitNumber : splitNumbers) {
            checkIsNumber(splitNumber);
        }
    }

    public void checkStartOrEndWithComma(String input) throws IllegalArgumentException {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 입력 형식입니다.");
        }
    }
}
