package lotto.utils;

public enum LottoExceptions {

    DuplicateError("[ERROR} 중복되는 숫자는 입력할 수 없습니다."),
    NotInRangeError("[ERROR] 숫자는 1과 45사이의 수여야 합니다."),
    InputTypeError("[ERROR] 숫자만 입력해주세요."),
    InvalidCountError("[ERROR] 6개의 숫자를 입력해주세요."),
    CurrencyUnitError("[ERROR] 1000원 단위로 입력해주세요.");


    private final String errorMessage;

    LottoExceptions(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
