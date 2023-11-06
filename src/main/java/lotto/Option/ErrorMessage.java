package lotto.Option;

public enum ErrorMessage {
    ONE_TO_FORTY_FIVE("로또 번호는 1부터 45 사이의 숫자여야 합니다."), //컨벤션 확인
    NOT_LOTTO_DUPLICATION("중복된 숫자는 입력할 수 없습니다."),
    NOT_BONUS_DUPLICATION("중복된 보너스 숫자는 입력할 수 없습니다."),
    NOT_NEGATIVE_NUMBER("음수는 입력할 수 없습니다."),
    NOT_ZERO("0원으로는 아무것도 구입할 수 없습니다."),
    NOT_DIVISION_1000("1000으로 나누어 떨어지는 금액을 입력하세요."),
    NOT_NUMBER("숫자를 입력해주세요."),
    NOT_SIX_LENGTH("로또 번호는 6개여야 합니다.");

    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }
}
