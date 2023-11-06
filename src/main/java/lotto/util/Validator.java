package lotto.util;

public class Validator {
    private static final double MAX_MONEY = 2E9;
    private static final int MIN_SIZE = 4;
    private static final int MAX_SIZE = 10;
    private static final int ZERO_INDEX = 0;
    private static final int UNIT = 1000;
    private static final char ZERO_CHARACTER = '0';

    public void money(String inputMoney) {
        checkSize(inputMoney);
        checkNum(inputMoney);
        checkRange(Double.valueOf(inputMoney));
        checkDividable(Integer.valueOf(inputMoney));
    }

    private void checkSize(String inputMoney) {
        int size = inputMoney.length();
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.SIZE.getMessage());
        }
    }

    private void checkNum(String inputMoney) {
        char frontNum = inputMoney.charAt(ZERO_INDEX);
        boolean isNum = inputMoney.chars().allMatch(Character::isDigit);
        if (!isNum || frontNum == ZERO_CHARACTER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER.getMessage());
        }
    }

    private void checkRange(double money) {
        if (money >= MAX_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.RANGE.getMessage());
        }
    }

    private void checkDividable(int money) {
        if (money % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNIT.getMessage());
        }
    }
}
