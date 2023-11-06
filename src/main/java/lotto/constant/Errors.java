package lotto.constant;

public enum Errors {

    PURCHASE_AMOUNT_UNDER_THOUSAND_MESSAGE("[ERROR] 구매 가격은 1000원 이상이여야 합니다."),
    PURCHASE_AMOUNT_REMAIN_NOT_ZERO_MESSAGE("[ERROR] 구매 가격은 1000원 단위로 입력되어야 합니다."),
    PURCHASE_AMOUNT_NOT_INTEGER_MESSAGE("[ERROR] 구매 가격은 정수만 가능합니다.");

    private final String errorMessage;
    Errors(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
