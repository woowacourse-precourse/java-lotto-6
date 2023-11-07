package lotto.type;

public enum ExceptionMessage {

    NOT_NUMBER("[ERROR] 숫자를 입력해주세요"),
    NOT_CONDITIONAL_NUMBER("[ERROR] 숫자는 " + ConditionSetting.MIN_NUMBER.getValue() + " ~ " +
            ConditionSetting.MAX_NUMBER.getValue() + "사이어야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 번호가 중복되었습니다."),
    NOT_CONDITIONAL_COUNT("[ERROR] 번호는 " + ConditionSetting.COUNT.getValue() + "개 입력해야합니다."),
    NOT_PRICE_UNIT("[ERROR] 1000단위로만 입력해주세요");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
