package lotto.ENUM;

public enum ExceptionCase {
    NOT_SATISFY_CONDITION_OF_PURCHASE_AMOUNT("[ERROR] 구입금액은 1000원 단위 이여야 합니다."),
    PURCHASE_AMOUNT_IS_NOT_INTEGER("[ERROR] 구입금액은 숫자여야 합니다."),
    LOTTERY_NUMBER_SIZE_IS_NOT_SIX("[ERROR] 로또 번호는 총 6개 입니다."),
    DUPLICATION_OF_LOTTERY_NUMBERS("[ERROR] 로또 번호는 중복 될 수 없습니다"),
    DUPLICATION_OF_WINNING_NUMBERS("[ERROR] 당첨 번호는 중복 될 수 없습니다"),
    WINNING_NUMBER_IS_NOT_INTEGER("[ERROR] 당첨 입력은 숫자여야 합니다."),
    BONUS_NUMBER_IS_NOT_INTEGER("[ERROR] 보너스 입력은 숫자여야 합니다.");


    private String errMessage;

    ExceptionCase(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
