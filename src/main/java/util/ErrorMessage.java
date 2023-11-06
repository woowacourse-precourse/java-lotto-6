package util;

public enum ErrorMessage {

    PRICE_DOESNT_ENTER("[ERROR] 구매 금액이 입력되지 않았습니다. 금액을 다시 입력해 주세요"),
    PRICE_ISNT_IN_STANDARD_UNIT("[ERROR] 구매 금액이 천원 단위가 아닙니다. 구매 금액은 천원 단원로 입력해 주세요."),
    PRICE_CONTAIN_NON_NUMERIC_CHARACTER("[ERROR] 구매 금액에 숫자 이외의 문자(공백 포함)가 입력되었습니다. 숫자만 입력해 주세요."),
    PRICE_IS_NEGATIVE("[ERROR] 구매 금액은 0 이상인 정수만 입력해 주세요."),
    WINNNING_NUMBER_DOESNT_ENTER("[ERROR] 당첨 번호가 입력되지 않았습니다. 금액을 다시 입력해 주세요"),
    BONUS_NUMBER_DOESNT_ENTER("[ERROR] 보너스 번호가 입력되지 않았습니다. 금액을 다시 입력해 주세요."),
    LOTTO_MUST_CONTAIN_SIX_NUMBERS("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_CONTAIN_DULPICATE_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다. 중복되지 않은 숫자를 입력해 주세요."),
    WINNING_NUMER_AND_BONUS_NUMBER_ARE_SAME("[ERROR] 보너스 번호는 당첨 번호와 중복 되지 않아야 합니다. 중복되지 않은 숫자를 입력해 주세요."),
    OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
