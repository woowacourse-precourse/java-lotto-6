package lotto.Exception;

public enum BonusNumberErrorMessage {
    NO_BONUS_NUMBER_ENTERED("[ERROR] 보너스 번호를 입력해 주세요."),
    TOO_MANY_BONUS_NUMBERS("[ERROR] 보너스 번호는 1개만 입력해 주세요.");

    private final String message;

    BonusNumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
