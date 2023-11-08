package lotto.view.constants;

public enum ConstantsMessage {
    ASK_BUY_PRICE("구입 금액을 입력해 주세요."),
    BUY_RESULT_MESSAGE("개를 구매했습니다."),
    ASK_PRIZE_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WIN_RESULT_MESSAGE("당첨통계"),
    lINE_SEPARATION_MESSAGE("---"),
    PERCENT_FRONT_MESSAGE("총 수익률은"),
    PERCENT_BACK_MESSAGE("%입니다.");

    private final String message;

    ConstantsMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
