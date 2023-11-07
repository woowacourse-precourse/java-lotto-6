package lotto.utils;

public enum ExceptionMessage {
    NUMBER("[ERROR] 숫자만 입력해주세요. 구매금액을 다시 입력해주세요."),
    THOUSAND("[ERROR] 천원 단위로 입력해주세요. 구매금액을 다시 입력해주세요."),
    WINNING_NUMBER("[ERROR] 숫자와 콤마만 이용하여 입력하세요. 당첨 번호를 다시 입력해 주세요.");

    private String value;

    ExceptionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExceptionMessage[] getSuccessCodes() {
        return new ExceptionMessage[] {
            NUMBER, THOUSAND
        };
    }
}
