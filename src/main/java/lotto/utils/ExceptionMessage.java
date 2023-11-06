package lotto.utils;

public enum ExceptionMessage {
    NUMBER("[ERROR] 숫자만 입력해주세요. 구매금액을 입력해 주세요."),
    THOUSAND("[ERROR] 천원 단위로 입력하세요.");

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
