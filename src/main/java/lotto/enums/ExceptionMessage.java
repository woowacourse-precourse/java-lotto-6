package lotto.enums;

public enum ExceptionMessage {

    PURCHASE_MONEY_IS_NOT_DIVIDENED_BY_ONE_THOUSAND("구입 금액은 1,000단위여야 합니다."),
    PURCHASE_MONEY_IS_EMPTY_VALUE("아무런 값도 입력되지 않았습니다. 1,000단위의 숫자값을 입력해야 합니다."),
    PURCHASE_MONEY_IS_NOT_NUMBER("문자가 입력되었습니다. 1,000단위의 숫자값을 입력해야 합니다."),
    PURCHASE_MONEY_IS_NOT_OVER_ONE_THOUSAND("1,000원보다 작은 금액이 입력되었습니다. 1,000단위의 숫자값을 입력해야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message){
        this.message = ERROR_TAG + message;
    }

    public void throwException(){
        throw new IllegalArgumentException(message);
    }
}
