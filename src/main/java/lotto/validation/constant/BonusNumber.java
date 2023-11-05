package lotto.validation.constant;

public enum BonusNumber {

    DUPLICATION_BONUS_NUMBER("[ERROR] 보너스 번호와 당첨 번호는 중복 될 수 없습니다.");

    private String message;

    BonusNumber(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
