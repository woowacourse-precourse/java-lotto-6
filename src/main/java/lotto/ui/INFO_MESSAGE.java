package lotto.ui;

public enum INFO_MESSAGE {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    STATISTICS_MESSAGE("당첨 통계\n---"),
    COUNT_FORMAT("%d개를 구매했습니다.\n");

    private final String value;

    INFO_MESSAGE(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
