package lotto.contents;

public enum ContentErrors {
    NEGATIVE_AMOUNT("[ERROR] 구입 금액은 음수일 수 없습니다."),
    INVALID_AMOUNT("[ERROR] 입력한 금액이 유효하지 않습니다. 1,000원 단위로 입력해주세요."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자 형식이 올바르지 않습니다."),
    INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    VALID_LOTTO_NUMBERS_COUNT("[ERROR] 당첨 번호의 갯수는 6개여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호가 올바르지 않습니다."),
    INVALID_OUT_OF_RANGE("[ERROR] 로또의 1인당 최대 구매금액은 100,000원 입니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BLANK_SPACE_IN_INPUT("[ERROR] 입력 값에 공백이 포함될 수 없습니다."),
    INPUT_OUT_OF_RANGE("[ERROR] 입력값의 길이가 초과됐습니다.");


    private final String errorMessage;

    ContentErrors(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}


