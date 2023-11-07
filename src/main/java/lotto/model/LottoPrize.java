package lotto.model;

public enum LottoPrize {
    FIRST_PRIZE(0,"6개 일치 (2,000,000,000원) - ","개"),
    SECOND_PRIZE(0,"5개 일치, 보너스 볼 일치 (30,000,000원) - ","개"),
    THIRD_PRIZE(0,"5개 일치 (1,500,000원) - ","개"),
    FOURTH_PRIZE(0,"4개 일치 (50,000원) - ","개"),
    FIFTH_PRIZE(0,"3개 일치 (5,000원) - ","개"),
    LOOSE(0,"","개");

    private int winCount;
    private final String text;

    private final String unit;

    LottoPrize(int winCount, String text, String unit) {
        this.winCount = winCount;
        this.text = text;
        this.unit = unit;
    }
    public int getWinCount() {
        return winCount;
    }
    public String getText() {
        return text;
    }
    public String getUnit() {
        return unit;
    }

    public void addWinCount() {
        this.winCount ++;
    }
}
