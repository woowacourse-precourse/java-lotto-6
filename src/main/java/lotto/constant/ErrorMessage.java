package lotto.constant;

public enum ErrorMessage {
    // 로또 구입 금액
    NAN("구입 금액은 숫자여야 합니다."),
    INDIVISIBLE_BY_1000("구입 금액은 1,000원으로 나누어 떨어져야 합니다."),
    MIN("최소 구입 금액은 1,000원입니다."),

    // 당첨 번호, 보너스 번호
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OUT_OF_COUNT("당첨 번호는 6개를 입력하셔야 합니다."),
    DUPLICATED_WINNING("당첨 번호는 서로 다른 숫자여야 합니다."),
    DUPLICATED_WINNING_WITH_BONUS("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
