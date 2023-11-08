package lotto.view;

public enum ViewPrompt {
    // InputView
    WELCOME_MESSAGE("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요"),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    // OutputView
    PURCHASE_MESSAGE("개를 구매했습니다."),
    OUTPUT_START_MESSAGE("당첨 통계"),
    LINE("---");

    private final String message;

    ViewPrompt(String message) {
        this.message = message;
    }

    public java.lang.String getMessage() {
        return message;
    }
}
