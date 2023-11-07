package lotto.domain;

public class Bonus {
    private final int bonus;
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.";
    private static final String NUMBER_PARSE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자를 입력해야 합니다.";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private Bonus(int bonus) {
        validateOutOfRange(bonus);
        this.bonus = bonus;
    }

    public static Bonus from(String bonus) {
        return new Bonus(convertBonusNumber(bonus));
    }

    private static int convertBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
        return Integer.parseInt(bonusNumber);
    }

    public void validateOutOfRange(int bonus) {
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_PARSE_EXCEPTION_MESSAGE);
        }
    }

    public int getBonus() {
        return bonus;
    }
}
