package lotto.code;

public enum ExceptionMessage {
    AMOUNT_NUMBER_ERROR("[ERROR] 로또 구입 금액은 1000원 단위로 입력하셔야 합니다."),
    LOTTO_NUMBER_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_VALID_ERROR("[ERROR] 로또 번호는 6개의 중복되지 않는 숫자를 입력 해주셔야 합니다."),
    BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 중복되지 않는 숫자여야 합니다.");

    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage(){
        return message;
    }
}
