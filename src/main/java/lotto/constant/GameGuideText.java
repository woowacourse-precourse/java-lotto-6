package lotto.constant;

public enum GameGuideText {

    ENTER_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    PURCHASE_LOTTO("개를 구매했습니다."),
    ENTER_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---\n");

    private String text;

    GameGuideText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
