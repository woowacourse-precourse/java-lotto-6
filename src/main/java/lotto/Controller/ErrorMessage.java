package lotto.Controller;

public enum ErrorMessage {
    INPUT_NONE("[ERROR] 입력이 없습니다"),
    NOT_INTEGER("[ERROR] 입력은 숫자여야 합니다."),
    CASH_NOT_THOUSAND("[ERROR] 입력 금액은 1000원 단위로 입력되어야 합니다."),
    CASH_NOT_POSITIVE("[ERROR] 입력 금액은 0원을 초과해야 합니다."),
    BONUS_OUT_RANGE("[ERROR] 보너스 번호는 1~45 사이어야 합니다."),

    LOTTO_NOT_NUMBER("[ERROR] 로또는 숫자로만 이루어져 있어야 합니다."),
    LOTTO_LENGTH("[ERROR] 로또의 번호는 6자리이어야 합니다."),
    LOTTO_OUT_RANGE("[ERROR] 로또의 번호는 1~45 사이어야 합니다."),
    LOTTO_DUPLICATE("[ERROR] 로또의 번호는 서로 다른 숫자여야 합니다.");


    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

}