package lotto.domain;

public enum Rank {
    RANK_1("6개 일치 (2,000,000,000원) - ", 2000000000),
    RANK_2("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    RANK_3("5개 일치 (1,500,000원) - ", 1500000),
    RANK_4("4개 일치 (50,000원) - ", 50000),
    RANK_5("3개 일치 (5,000원) - ", 5000),
    UNRANK(null, null);

    private final String outputMessage;
    private final Integer prize;

    Rank(String outputMessage, Integer prize) {
        this.outputMessage = outputMessage;
        this.prize = prize;
    }

    public String getOutputMessage() {
        return this.outputMessage;
    }

    public Integer getPrize() {
        return prize;
    }
}