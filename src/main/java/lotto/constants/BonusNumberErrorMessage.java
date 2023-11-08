package lotto.constants;

public enum BonusNumberErrorMessage implements ErrorMessage {

    NUMERIC_INVALID("보너스 번호는 숫자여야 합니다."),
    RANGE_INVALID("보너스 번호는 1~45의 숫자여야 합니다."),
    DUPLICATE_WINNING_BUNDLE_INVALID("당첨 번호와 보너스 번호는 일치할 수 없습니다.");

    private final String message;

    BonusNumberErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
