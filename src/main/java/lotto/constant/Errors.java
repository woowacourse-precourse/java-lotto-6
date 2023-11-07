package lotto.constant;

public enum Errors {

    PURCHASE_AMOUNT_UNDER_THOUSAND_MESSAGE("[ERROR] 구매 가격은 1000원 이상이여야 합니다."),
    PURCHASE_AMOUNT_REMAIN_NOT_ZERO_MESSAGE("[ERROR] 구매 가격은 1000원 단위로 입력되어야 합니다."),
    PURCHASE_AMOUNT_NOT_INTEGER_MESSAGE("[ERROR] 구매 가격은 정수만 가능합니다."),
    WINNING_NUMBER_WRONG_SIZE_MESSAGE("[ERROR] 로또 번호의 개수는 6개만 가능합니다."),
    WINNIG_NUMBER_NOT_INTEGER("[ERROR] 로또 번호에 문자가 존재합니다."),
    WINNING_NUMBER_WRONG_RANGE_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNIG_NUMBER_DUPLICATE_MESSAGE("[ERROR] 로또 번호에 중복된 수가 존재합니다."),
    BONUS_NUMBER_NOT_INTEGER_MESSAGE("[ERROR] 보너스 번호는 정수만 가능합니다."),
    BONUS_NUMBER_DUPLICATE_MESSAGE("[ERROR] 당첨 번호에 보너스 번호와 중복된 수가 존재합니다.");

    private final String errorMessage;
    Errors(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
