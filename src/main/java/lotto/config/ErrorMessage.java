package lotto.config;

public enum ErrorMessage {
    SPACE_OR_EMPTY("[ERROR] 공백 혹은 빈 문자열을 입력하였습니다."),
    NULL("[ERROR] Null을 입력하였습니다."),
    STRING_IS_NOT_INT("[ERROR] 숫자를 입력해주세요"),
    NUMBER_IS_NOT_IN_RANGE("[ERROR] 주어진 수는 " +
            ConstantNum.LOTTO_NUMBER_MIN + " 이상, " +
            ConstantNum.LOTTO_NUMBER_MAX + " 이하가 아닙니다."),
    NOT_ENOUGH_LOTTO_NUMBERS("[ERROR] 주어진 당첨 번호의 개수는 " +
            ConstantNum.LOTTO_NUMBER_CNT.getNum() +
            "가 아닙니다."),
    NOT_ENOUGH_BONUS("[ERROR] 주어진 보너스 번호의 개수는 " +
            ConstantNum.LOTTO_BONUS_NUMBER_CNT.getNum() +
            "가 아닙니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
