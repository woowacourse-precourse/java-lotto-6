package lotto.domain;

public enum LottoReward {
    FIRST(6, "2,000,000,000원"),
    SECOND(5, "30,000,00원"),
    THIRD(5, "1,500,000원"),
    FOURTH(4, "50,000원"),
    FIFTH(3, "5,000원"),
    NOTHING(0,"0원");

    private Integer matchCount;
    private String reward;

    LottoReward(Integer matchCount, String reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }
}
