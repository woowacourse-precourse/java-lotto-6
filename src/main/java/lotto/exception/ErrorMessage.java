package lotto.exception;

public enum ErrorMessage {
    NOT_INTEGER_MESSAGE("숫자만 입력 가능합니다."),
    NOT_THOUSAND_MESSAGE("1000의 배수만 입력 가능합니다."),
    PRICE_OUT_OF_RANGE_MESSAGE(String.format("최소 주문 금액 : %,d / 최대 주문 금액 : %,d", PriceValidator.PURCHASE_COST, PriceValidator.MAX_PURCHASE_COST)),
    DUPLICATE_NUMBER_MESSAGE("중복 숫자는 허용되지 않습니다."),
    LOTTONUMBER_OUT_OF_RANGE_MESSAGE("1~45 사이의 숫자만 입력 가능합니다.")
    ;
    final String message;
    ErrorMessage(String message){
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
