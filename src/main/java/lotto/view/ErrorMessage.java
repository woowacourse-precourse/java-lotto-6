package lotto.view;

public enum ErrorMessage {
    LOTTO_COMBINATION_HAVE_SIX_NUMBER("[ERROR] 로또 번호 조합은 6개의 숫자로 이루어져 있습니다."),
    LOTTO_COMBINATION_DO_NOT_HAVE_DUPLICATES("[ERROR] 로또 번호 조합에는 중복된 숫자가 없어야 합니다."),
    LOTTO_NUMBER_RANGE_IS_BETWEEN_ONE_AND_FORTYFIVE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_A_NUMBER("[ERROR] 입력값이 숫자가 아닙니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
