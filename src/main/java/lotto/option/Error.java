package lotto.option;

public enum Error {
    ONE_TO_FORTY_FIVE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_LOTTO_DUPLICATION("중복된 숫자는 입력할 수 없습니다."),
    NOT_BONUS_DUPLICATION("중복된 보너스 숫자는 입력할 수 없습니다."),
    NOT_NEGATIVE_NUMBER("음수는 입력할 수 없습니다."),
    NOT_ZERO("0원으로는 아무것도 구입할 수 없습니다."),
    NOT_DIVISION_1000("1000으로 나누어 떨어지는 금액을 입력하세요."),
    NOT_NUMBER("10자리 이하의 숫자를 입력해주세요."),
    NOT_SIX_LENGTH("로또 번호는 6개여야 합니다.");

    private final String message;

    private Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
