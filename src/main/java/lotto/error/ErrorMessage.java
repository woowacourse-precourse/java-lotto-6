package lotto.error;

public enum ErrorMessage {

    // 로또 번호
    NOT_RIGHT_SIZE_LOTTO_NUMBER("로또 번호는 총 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    OVER_RANGE_LOTTO_NUMBER("로또 번호는 1~45사이의 숫자여야 합니다."),
    
    // 로또 구입 금액
    NOT_INTEGER_LOTTO_PURCHASE_AMOUNT("로또 구입 금액은 숫자만으로 이루어져야 합니다."),
    START_ZERO_LOTTO_PURCHASE_AMOUNT("로또 구입 금액은 0으로 시작할 수 없습니다."),
    NOT_DIVIDE_LOTTO_PURCHASE_MINIMUM_AMOUNT("로또 구입 금액은 1000으로 나누어 떨어져야 합니다."),

    // 당첨 번호
    BLANK_LOTTO_WINNING_NUMBER("제대로 입력되지 않은 로또 당첨 번호가 존재합니다."),
    NOT_INTEGER_WINNING_NUMBER("당첨 번호는 숫자만으로 이루어져야 합니다."),
    START_ZERO_WINNING_NUMBER("당첨 번호는 0으로 시작할 수 없습니다."),
    NOT_RIGHT_SIZE_WINNING_NUMBER("당첨 번호는 총 6개여야 합니다."),

    // 보너스 번호
    NOT_INTEGER_BONUS_NUMBER("보너스 번호는 숫자여야 합니다."),
    START_ZERO_BONUS_NUMBER("보너스 번호는 0으로 시작할 수 없습니다."),
    OVER_RANGE_BONUS_NUMBER("보너스 번호는 1~45사이의 숫자여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
