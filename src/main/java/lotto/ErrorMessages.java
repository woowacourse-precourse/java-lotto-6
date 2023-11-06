package lotto;

public enum ErrorMessages {
    ERROR_NOT_NUMBER("[ERROR] 양의 정수를 입력해 주세요"),
    ERROR_NOT_MULTIPLE_OF_UNIT("[ERROR] " + Config.UNIT + "부터 " + Integer.MAX_VALUE + " 사이의 " + Config.UNIT
            + "의 배수를 입력해 주세요."),
    ERROR_SIZE_INCORRECT("[ERROR] " + Config.SIZE_OF_LOTTO + "개의 숫자를 입력해 주세요. (숫자는 " + Config.SPLIT_SYMBOL
            + "기호로 구분됩니다.)"),
    ERROR_OUT_OF_RANGE_LOTT_NUMBER("[ERROR] 로또 번호는 " + Config.MIN_LOTTO_NUMBER + "부터 " + Config.MAX_LOTTO_NUMBER
            + " 사이의 숫자여야 합니다."),
    ERROR_WINNING_NUMBER_DUPLICATE("[ERROR] 당첨 번호는 서로 중복되지 않아야 합니다."),
    ERROR_BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
