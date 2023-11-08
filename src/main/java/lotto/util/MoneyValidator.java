package lotto.util;

public class MoneyValidator {
    private static final long MAX_MONEY = (long) 2E9;
    private static final int MIN_SIZE = 4;
    private static final int MAX_SIZE = 10;
    private static final int ZERO_INDEX = 0;
    private static final int UNIT = 1000;
    private static final char ZERO_CHARACTER = '0';

    public void money(String inputMoney) {
        checkSize(inputMoney);
        checkNum(inputMoney);
        checkRange(Long.valueOf(inputMoney));
        checkDividable(Integer.valueOf(inputMoney));
    }

    /**
     * 입력 크기 확인
     * <p>
     * 숫자 값을 확인하기 전에 크기로 먼저 검증
     *
     * @param inputMoney 금액
     */
    private void checkSize(String inputMoney) {
        int size = inputMoney.length();
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.SIZE.getMessage());
        }
    }

    /**
     * 숫자인지 검증, 맨 앞 0은 불가
     *
     * @param inputMoney 금액
     */
    private void checkNum(String inputMoney) {
        char frontNum = inputMoney.charAt(ZERO_INDEX);
        boolean isNum = inputMoney.chars().allMatch(Character::isDigit);
        if (!isNum || frontNum == ZERO_CHARACTER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER.getMessage());
        }
    }

    /**
     * 20억원 이상은 불가하도록 검증.
     *
     * @param money 금액
     */
    private void checkRange(long money) {
        if (money >= MAX_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.RANGE.getMessage());
        }
    }

    /**
     * 1000원 단위로 나누어지는 지 확인
     *
     * @param money 금액
     */
    private void checkDividable(int money) {
        if (money % UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNIT.getMessage());
        }
    }
}
