package lotto.utils;

public enum ExceptionMessage {
    NUMBER("[ERROR] 숫자만 입력해주세요."),
    THOUSAND("[ERROR] 천원 단위로 입력해주세요."),
    WINNING_NUMBER("[ERROR] 숫자와 콤마만 이용하여 입력하세요."),
    WINNING_NUMBER_TOTAL("[ERROR] 번호를 6개 입력해주세요."),
    WINNING_NUMBER_RANGE("[ERROR] 번호는 1부터 45까지 입력해주세요."),
    WINNING_NUMBER_DUPLICATE("[ERROR] 중복된 번호는 입력할 수 없습니다.");

    private String value;

    ExceptionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
