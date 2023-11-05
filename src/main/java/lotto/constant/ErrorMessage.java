package lotto.constant;

public enum ErrorMessage {
    ERROR_CONTAIN_SPACE("[ERROR] 입력값 안에 공백이 포함돼 있습니다."),
    ERROR_NOT_NUMBER("[ERROR] 숫자만 입력해 주세요."),
    ERROR_NOT_FIRST_ZERO("[ERROR] 첫 숫자는 0이 될 수 없습니다."),
    ERROR_NOT_UNIT("[ERROR] 입력값이 1000원 단위가 아닙니다."),
    ERROR_OVER_MAX("[ERROR] 로또 최대 구매 금액을 초과했습니다."),
    ERROR_LOTTO_SIZE("[ERROR] 로또 번호는 6개가 되어야 합니다."),
    ERROR_LOTTO_DUPLICATE("[ERROR] 로또 번호는 중복일 수 없습니다."),
    ERROR_LOTTO_RANGE("[ERROR] 입력값은 1에서 45 사이의 숫자여야 합니다.");

    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
