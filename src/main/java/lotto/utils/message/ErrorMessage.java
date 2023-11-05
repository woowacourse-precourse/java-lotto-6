package lotto.utils.message;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    ERROR_NOT_NUMBER("로또 번호는 숫자만 입력할 수 있습니다."),
    ERROR_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    ERROR_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_AMOUNT_UNIT("구입금액은 1,000원 단위여야 합니다."),
    ERROR_NO_AMOUNT("구입금액은 0원 이상 입력해야 합니다."),
    ERROR_DUPLICATED_NUMBER("당첨 번호에 중복된 숫자가 있으면 안 됩니다."),
    ERROR_DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
