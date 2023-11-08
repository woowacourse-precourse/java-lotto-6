package lotto.util.rule;

public enum RankingRule {

    RANK_FIRST("6개 일치", "2,000,000,000"),
    RANK_SECOND("5개 일치, 보너스 볼 일치", "30,000,000"),
    RANK_THIRD("5개 일치", "1,500,000"),
    RANK_FOURTH("4개 일치", "50,000"),
    RANK_FIFTH("3개 일치", "5,000");

    private final String content;
    private final String prize;

    RankingRule(String content, String prize) {
        this.content = content;
        this.prize = prize;
    }

    public String getContent() {
        return content;
    }

    public String getPrize() {
        return prize;
    }

}
