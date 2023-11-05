package exception;

public enum ExceptionMessage {

    PURCHASE_AMOUNT_IS_STRING("[ERROR] 구입 금액은 정수여야 합니다."),
    PURCHASE_AMOUNT_REMAIN("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    PURCHASE_AMOUNT_OVERFLOW("[ERROR] 구입 금액의 범위는 2,000,000,000원 이하여야 합니다."),
    PURCHASE_AMOUNT_NEGATIVE_NUMBER("[ERROR] 구입 금액은 양수여야 합니다.");


    private String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String message(){
        return message;
    }
}
