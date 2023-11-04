package lotto.constants;

public enum GuideMessage {
    INPUT_BUY_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    OUTPUT_BUY_LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    INPUT_HIT_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_HIT_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
