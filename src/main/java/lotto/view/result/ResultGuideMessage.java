package lotto.view.result;

public enum ResultGuideMessage {

    RESULT_PRIZE_GUIDE("당첨 통계" + System.lineSeparator() + "---");

    private final String guide;

    ResultGuideMessage(String guide) {
        this.guide = guide;
    }

    public String getGuide() {
        return guide;
    }

}
