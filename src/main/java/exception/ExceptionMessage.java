package exception;

public enum ExceptionMessage {

    PURCHASE_AMOUNT_IS_STRING("[ERROR] 구입 금액은 정수여야 합니다."),
    PURCHASE_AMOUNT_REMAIN("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    PURCHASE_AMOUNT_OVERFLOW("[ERROR] 구입 금액의 범위는 2,000,000,000원 이하여야 합니다."),
    PURCHASE_AMOUNT_NEGATIVE_NUMBER("[ERROR] 구입 금액은 양수여야 합니다."),
    WINNING_NUMBERS_IS_NULL("[ERROR] 당첨 번호가 입력되지 않았습니다."),
    NUMBER_IS_STRING("[ERROR] 숫자가 아닌 문자열이 입력되었습니다."),
    WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호는 6개여야 합니다."),
    WINNING_NUMBERS_RANGE("[ERROR] 당첨 번호는 1~45사이의 정수여야 합니다."),
    WINNING_NUMBERS_DUPLICATE("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    BONUS_DUPLICATE_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String message(){
        return message;
    }
}
