package lotto.view;

public enum ErrorMessage {
    LOTTO_COMBINATION_HAVE_SIX_NUMBER("[ERROR] 로또 번호 조합은 6개의 숫자로 이루어져 있습니다."),
    LOTTO_COMBINATION_DO_NOT_HAVE_DUPLICATES("[ERROR] 로또 번호 조합에는 중복된 숫자가 없어야 합니다."),
    LOTTO_NUMBER_RANGE_IS_BETWEEN_ONE_AND_FORTYFIVE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_COMBINATION_HAS_NOT_NUMBER_VALUE("[ERROR] 로또 번호 조합에 숫자가 아닌 값이 포함되어 있습니다."),
    RECEIVED_MONEY_NOT_MULTIPLE_OF_1000("[ERROR] 로또는 1000원 단위로 구매 가능합니다."),
    NOT_A_INTEGER_NUMBER("[ERROR] 입력값이 정수가 아닙니다.");


    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
