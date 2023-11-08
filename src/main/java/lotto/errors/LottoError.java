package lotto.errors;

public enum LottoError {

    NOT_SIX_LOTTO("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_LOTTO_NUMBER_ARRANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String errorMessage;

    LottoError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
