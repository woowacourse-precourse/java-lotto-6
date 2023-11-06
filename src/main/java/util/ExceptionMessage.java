package util;

/**
 * packageName    : util
 * fileName       : ExceptionMessage
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public enum ExceptionMessage {
    PURCHASE_AMOUNT_IS_NOT_NUMBER("금액을 입력해 주셔야 합니다."),
    PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO("0보다 큰 금액을 투입해 주셔야 합니다."),
    PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS("입력 금액은 1,000원 단위여야 합니다.");
    private static final String ERROR_TAG = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message){
        this.message = ERROR_TAG + message;
    }

    public String getMessage(){
        return message;
    }

    public void throwException(){
        throw new IllegalArgumentException(message);
    }
}
