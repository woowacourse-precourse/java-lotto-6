package lotto.domain.constant;

public enum Rank {

    FIRST("6개 일치 (2,000,000,000원)", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    THIRD("5개 일치 (1,500,000원)", 15000000),
    FORTH("4개 일치 (50,000원)", 50000),
    FIFTH("3개 일치 (5,000원)", 5000);

    private final String description;
    private final int reward;

    Rank(String description, int reward) {
        this.description = description;
        this.reward = reward;
    }
}
