package lotto;

public enum ErrorMessage {
    RAINGE_MESSAGE("[ERROR] 숫자는 1~45여야 합니다."),
    DUPLICATED_IN("[ERROR] 숫자가 중복되면 안됩니다."),
    DUPLICATED_WITH("[ERROR] 보너스 숫자가 당첨 번호와 중복됩니다."),
    IS_BLANK("[ERROR] 값이 비어있습니다."),
    NOT_NUMBER("[ERROR] 값에는 숫자만 입력해야 합니다."),
    NOT_POSITIVE("[ERROR] 금액은 양수를 입력해야 합니다"),
    NOT_DIVIDED("[ERROR] 1,000원 단위로 금액을 입력해야 합니다."),
    NOT_SIX("[ERROR] 로또 숫자는 6개여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
