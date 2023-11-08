package lotto.utils;

public enum LottoPlace {
    NONE(0, 0, ""),
    FIFTH(5, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(3, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(2, 3000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(1, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int place;
    private final int reward;
    private final String description;

    LottoPlace(final int place, final int reward, final String description) {
        this.place = place;
        this.reward = reward;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public int getReward(){
        return this.reward;
    }
}
