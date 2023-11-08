package lotto.constant;

public enum ErrorMessage {
    CHECK_BLANK("[ERROR] 입력값이 공백입니다."),
    INVALID_WIN_NUMBER_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다." ),
    INVALID_WIN_NUMBER_SIZE("[ERROR] 당첨 번호의 개수가 6개여야 합니다."),
    DUPLICATION_WIN_NUMBER("[ERROR] 당첨 번호에 중복이 없어야 합니다." ),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." ),
    INVALID_BONUS_NUMBER_SIZE("[ERROR] 보너스 번호의 개수가 1개여야 합니다." ),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." ),
    INVALID_LOTTE_NUMBER_SIZE("[ERROR] 로또 번호의 개수가 6개여야 합니다."),
    DUPLICATION_LOTTE_NUMBER("[ERROR] 로또 번호에 중복이 없어야 합니다." );

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
