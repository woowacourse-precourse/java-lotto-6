package validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final int TICKET_PRICE = 1000;
    private final int MAX_AMOUNT = 100000;
    private final int ZERO = 0;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
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

    public void checkStartOrEndWithComma(String input) throws IllegalArgumentException {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 입력 형식입니다.");
        }
    }

    public void checkCount(List<String> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력 갯수가 잘못되었습니다.");
        }
    }

    public void checkDuplicateNumber(List<Integer> numbers, int number) throws IllegalArgumentException {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 값이 있습니다.");
        }
    }

    public void checkNumberRange(int number) throws IllegalArgumentException {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "값이 범위를 벗어납니다.");
        }
    }
}
