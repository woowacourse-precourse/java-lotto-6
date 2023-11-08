package lotto.constant;

public enum ExceptionMessage {
    NUMBER_RANGE_MONEY("[ERROR] 숫자만 입력해주세요."),
    NUMBER_REMAIN_MONEY("[ERROR] 1000원 단위로 입력해 주시길 바랍니다."),
    NUMBER_LOW_RANGE_MONEY("[ERROR] 최소 금액은 1000원입니다."),
    NUMBER_NEGATIVE_RANGE_MONEY("[ERROR] 지폐난 동전외에 다른 것을 투입하지 마세요."),
    NUMBER_RANGE("[ERROR] 1과 45사이의 숫자를 입력하세요."),
    NUMBER_ONLY("[ERROR] 오직 숫자만을 입력하세요."),
    LOTTO_LENGTH("[ERROR] 로또에 들어가는 숫자는 6개입니다"),
    NUMBER_ONLY_LOTTO("[ERROR] 숫자와 쉽표만 입력하세요"),
    BONUS_NUMBER_IN_WINNING_LOTTO("[ERROR] 당첨 번호와 중복되는 숫자는 들어가면 안됩니다."),
    DUPICATE_NUMBER("[ERROR] 로또에 중복되는 숫자는 들어가면 안됩니다.");

    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
