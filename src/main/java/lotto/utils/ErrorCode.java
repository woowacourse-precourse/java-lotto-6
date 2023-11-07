package lotto.utils;

public enum ErrorCode {
    INVALID_NUMBERS("로또 번호는 "+Constants.MIN_LOTTO_NUMBER.getValues()+"부터 "+Constants.MAX_LOTTO_NUMBER.getValues()+" 사이의 숫자여야 합니다."),
    TOOMANY_NUMBERS(Constants.LOTTO_COUNT.getValues() +"개의 번호를 입력해주세요."),
    INVALID_MONEY(Constants.PRICE_UNIT.getValues()+"원 단위의 금액을 입력해주세요."),
    INPUT_IS_NULL("공백을 입력할 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] "+message;
    }
}
