package lotto;

public enum ErrorMessage {
    INDIVISIBLE_NUMBER("나누어 떨어지지 않는 금액 단위입니다."),
    ZERO_NUMBER("0원이 입력 됐습니다."),
    NOT_NUMBER_FORMAT("숫자가 아닌 돈이 입력 됐습니다."),
    OVER_LOTTO_SIZE("로또 번호의 개수가 적거나 많습니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호가 중복 됐습니다."),
    OVER_LOTTO_BOUNDARY("범위 밖의 로또 번호가 포함되었습니다."),
    DUPLICATE_WIN_BONUS("당첨번호와 보너스번호가 중복되었습니다."),
    OVER_BONUS_NUMBER_BOUNDARY("보너스번호가 범위를 벗어났습니다.");


    private final String message;
    private static final String errorMessage = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return errorMessage + message;
    }
}
