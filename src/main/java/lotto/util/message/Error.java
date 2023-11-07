package lotto.util.message;

public enum Error {

    MUST_INTEGER("[ERROR] 정수만 입력 가능합니다. 요청에 맞는 값을 입력 해주세요."),
    MUST_MONEY_UNIT("[ERROR] 금액은 %d원 단위만 가능합니다."),
    MUST_LOTTO_SIZE("[ERROR] 로또 번호는 %d자리만 가능합니다."),
    MUST_LOTTO_NO_DUP("[ERROR] 로또 번호는 중복될 수 없습니다."),
    MUST_LOTTO_RANGE("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다."),
    MUST_BONUS_NO_DUP_WINNING("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");

    private final String error;

    Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public String getError(int number) {
        return String.format(error, number);
    }

    public String getError(int first, int second) {
        return String.format(error, first, second);
    }
}
