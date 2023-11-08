package lotto.constants;


public enum ErrorMessage {
    INVALID_AMOUNT("[ERROR] 입력된 금액은 로또 티켓 가격(%d원)의 배수여야 합니다."),
    INSUFFICIENT_BALANCE("[ERROR] 잔액이 부족합니다. 로또 티켓을 더 이상 구매할 수 없습니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 %d부터 %d까지어야 합니다."),
    DUPLICATE_BONUS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_SIZE("[ERROR] 로또 번호는 %d개여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다 ."),
    INTEGER_REQUIRED("[ERROR] 입력된 값은 정수여야 합니다."),
    POSITIVE_REQUIRED("[ERROR] 입력된 값은 양수여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}