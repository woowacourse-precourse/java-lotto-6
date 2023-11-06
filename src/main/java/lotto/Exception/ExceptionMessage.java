package lotto.Exception;

public enum ExceptionMessage {

    TYPE_ERROR("[ERROR] 숫자만 입력 가능합니다."),
    RANGE_ERROR("[ERROR] 1부터 45 사이의 수를 입력해주세요."),
    DUPLICATION_LOTTO_NUMBER("[ERROR] 로또 번호가 중복되었습니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨번호와 같을 수 없습니다."),
    LOTTO_TICKET_PRICE("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다.");




    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
