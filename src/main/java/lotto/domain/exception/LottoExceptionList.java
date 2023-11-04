package lotto.domain.exception;

public enum LottoExceptionList {
    NUMBERS_DUPLICATE_ERROR("[ERROR] 중복된 숫자가 있습니다. 다시 입력해주세요."),
    NUMBERS_NOT_PURE_ERROR("[ERROR] 숫자만 입력해주세요."),
    NUMBERS_NOT_DIVIDED_ERROR("[ERROR] 구입 금액은 1,000원 단위로 입력하세요.");

    private final String message;
    LottoExceptionList(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
