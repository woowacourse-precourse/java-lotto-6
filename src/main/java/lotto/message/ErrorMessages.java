package lotto.message;

public enum ErrorMessages {

    INVALID_AMOUNT_FORMAT("[ERROR] 구입 금액에 문자가 들어갈 수 없습니다. 구입 금액은 숫자만 입력해주세요."),
    INVALID_AMOUNT_RANGE("[ERROR] 구입 금액 범위를 벗어났습니다. 1,000원 ~ 10,000,000원 내 금액을 입력해주세요."),
    INVALID_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
