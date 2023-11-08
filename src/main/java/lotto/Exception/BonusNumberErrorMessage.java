package lotto.Exception;

public enum BonusNumberErrorMessage {
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1~45 숫자만 입력이 가능합니다."),
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
