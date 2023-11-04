package lotto.bonus;

public class BonusNumber {

    public static final String NOT_INTEGER_MESSAGE = "보너스 번호는 정수로 입력해야 합니다.";
    private final Integer bonus;

    public BonusNumber(String bonus) {
        this.bonus = validate(bonus);
    }

    private Integer validate(String bonus) {
        try {
            return Integer.valueOf(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }
}
