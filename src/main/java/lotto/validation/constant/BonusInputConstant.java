package lotto.validation.constant;

public enum BonusInputConstant {

    DUPLICATION_BONUS_NUMBER("[ERROR] 보너스 번호와 당첨 번호는 중복 될 수 없습니다.");

    private final String message;

    BonusInputConstant(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
