package lotto.configuration;

public enum OutputConfiguration {
    INSERT_MONEY("구입금액을 입력해 주세요."),
    INSERT_WIN_NUMBER("당첨 번호를 입력해 주세요."),
    INSERT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTO("개를 구매했습니다."),
    WIN_STATISTICS("\n당첨 통계\n---\n");

    private final String message;

    OutputConfiguration(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
