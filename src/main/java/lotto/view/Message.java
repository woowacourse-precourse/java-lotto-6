package lotto.view;

public enum Message {
    FOR_BUY_AMOUNT("구입금액을 입력해 주세요. "),
    FOR_LOTTO_COUNT("%d개를 구매했습니다."),
    FOR_LOTTO("[%d, %d, %d, %d, %d, %d]"),
    ERROR_IS_NOT_PLUS_INT("양의 정수가 아닙니다."),
    ERROR_IS_NOT_THOUSAND_UNIT("1000의 단위가 아닙니다."),
    ERROR_IS_NOT_NUMBER("숫자가 아닙니다.");
    private final String label;

    Message(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

}