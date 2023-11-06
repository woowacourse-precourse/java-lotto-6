package lotto.constant;

public enum ErrorMessage {

    MONEY_ONLY_NUMBER("금액은 숫자로 입력이 되어져야 합니다!"),
    MONEY_UNIT_NUMBER("금액은 1000원 단위여야 합니다!"),

    MONEY_NO_NEGATIVE("금액은 음수가 아니라 양수여야 합니다!"),

    WINNUMBER_COMMA_DELIMITER("1,2,3,4,5,6 과 같은 형태로 ,로 구분을 해주세요!"),

    WINNUMBER_ONLY_NUMBER("당첨 번호는 숫자 와 구분자 , 만을 허용합니다!"),

    WINNUMBER_RANGE("당첨 번호의 숫자는 1-45 사이여야 합니다!"),

    WINNUMBER_NO_DUPLICATE_LENGTH("당첨 번호는 중복 없이 6개여야 합니다!"),

    WINNUMBER_LENGTH("당첨 번호는 6개여야 합니다!"),

    BONUS_NUMBER_ONLY_NUMBER("보너스 번호는 문자가 아닌 숫자로 와야 합니다!"),

    BONUS_NUMBER_RIGHT_RANGE("보너스 번호는 1-45 사이의 숫자여야 합니다!"),

    BONUS_NUMBER_NOT_NUPLICATED_WINNUMBER("보너스 번호가 당첨 번호와 중복이 되는 숫자로 와서는 안됩니다!");


    private String message;


    ErrorMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return "[ERROR] " + message;
    }
}
