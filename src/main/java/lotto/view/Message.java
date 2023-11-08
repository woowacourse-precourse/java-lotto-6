package lotto.view;

public enum Message {
    FOR_BUY_AMOUNT("구입금액을 입력해 주세요. "),
    FOR_LOTTO_COUNT("%d개를 구매했습니다."),
    FOR_LOTTO("[%d, %d, %d, %d, %d, %d]"),
    FOR_ANSWER_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    FOR_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ERROR_IS_NOT_PLUS_INT("양의 정수가 아닙니다."),
    ERROR_IS_NOT_THOUSAND_UNIT("1000의 단위가 아닙니다."),
    ERROR_IS_NOT_NUMBER("숫자가 아닙니다."),
    ERROR_IS_NOT_SIX_BY_COMMMA("쉼표로 구분했을 때 6개가 아닙니다."),
    ERROR_IS_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_IS_NOT_DISTICNT("중복된 숫자가 존재합니다.");

    private final String label;

    Message(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

}