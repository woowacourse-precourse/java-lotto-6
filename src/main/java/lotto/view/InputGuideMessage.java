package lotto.view;

public enum InputGuideMessage {

    LOTTO_PURCHASE_AMOUNT_INPUT_GUIDE("구입금액을 입력해 주세요.");

    private final String guide;

    InputGuideMessage(String guide) {
        this.guide = guide;
    }

    public String getGuide() {
        return guide;
    }

}
