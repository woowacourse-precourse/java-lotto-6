package lotto;

public enum ExceptionCase {
    NOT_SATISFY_CONDITION_OF_PURCHASE_AMOUNT("[ERROR_MESSAGE] 구입금액은 1000원 단위 이여야 합니다."),
    PURCHASE_AMOUNT_IS_NOT_INTEGER("[ERROR_MESSAGE] 구입금액은 숫자여야 합니다."),
    LOTTERY_NUMBER_SIZE_IS_NOT_SIX("[ERROR_MESSAGE] 로또번호는 총 6개 입니다."),
    DUPLICATION_OF_LOTTERY_NUMBERS("[ERROR_MESSAGE] 로또번호는 중복 될 수 없습니다"),
    WINNING_NUMBER_IS_NOT_INTEGER("[ERROR_MESSAGE] 구입금액은 숫자여야 합니다."),
    BONUS_NUMBER_IS_NOT_INTEGER("[ERROR_MESSAGE] 구입금액은 숫자여야 합니다.");


    private String errMessage;

    ExceptionCase(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
