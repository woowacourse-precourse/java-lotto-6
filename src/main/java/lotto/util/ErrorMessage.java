package lotto.util;

public enum ErrorMessage {
    NOT_INTEGER("[ERROR] 정수를 입력 해야 합니다."),
    BLANK_ERROR("[ERROR] 당첨 번호 입력에 공백은 허용되지 않습니다."),
    INPUT_FORMAT_ERROR("[ERROR] 당첨 번호 입력은 숫자와 ,로만 이루어 져야 합니다."),
    LOTTO_SIZE_ERROR("[ERROR] 숫자는 6개만 입력하세요."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 입력 가능한 로또 숫자 범위는 1 ~ 45입니다."),
    DUPLICATE_NUMBER_IN_WINNING_LOTTO("[ERROR] 당첨 번호 입력에 중복된 숫자를 넣지마세요."),
    MIN_PURCHASE_PRICE_ERROR("[ERROR] 최소 구매 금액은 1000원입니다."),
    PURCHASE_PRICE_REMAINDER_NOT_ZERO("[ERROR] 1000으로 나눠지지 않습니다. 1000원 단위로 입력해주세요."),
    BONUS_NUMBER_DUPLICATE_WITH_WIN_LOTTO("[ERROR] 보너스 번호가 당첨 번호와 겹칩니다.");

    String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
