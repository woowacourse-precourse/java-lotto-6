package lotto.constant;

public enum ExceptionConstant {

    BUYING_PRICE_INPUT_EXCEPTION("[ERROR] 구입 금액을 잘못 입력하셨습니다."),
    BUYING_PRICE_NUMBER_FORMAT_EXCEPTION("[ERROR] 구입 금액을 숫자 형식으로 입력해주세요.");

    public final String message;

    ExceptionConstant(final String message) {
        this.message = message;
    }
}
