package lotto;

public enum Messages {
    ASK_PRICE("구입금액을 입력해 주세요."),
    BUY_LOTTO_MESSAGE("개를 구매했습니다."),
    ONLY_NUMBER_ERROR_MESSAGE("[ERROR] 숫자만 입력 가능합니다."),
    AMOUNT_OF_MONEY_MUST_DIVIDED_THOUSAND("[ERROR] 금액은 1000원 단위로 나누어 떨어져야 합니다."),
    ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    BONUS_RANGE_EXCEPTION_MESSAGE("[ERROR] 보너스 번호는 1~45 사이의 숫자여야합니다."),
    BONUS_UNIQUE_NUMBER_EXCEPTION_MESSAGE("[ERROR] 보너스 번호는 로또 번호와 중복되지않아야합니다.");
    private String message;

    private Messages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
