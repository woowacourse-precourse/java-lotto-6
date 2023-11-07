package lotto;

public enum MATCHING {

    // Result Messages
    MATCH_THREE("3개 일치 (5,000원) - ",5000),
    MATCH_FOUR("4개 일치 (50,000원) - ", 50000),
    MATCH_FIVE("5개 일치 (1,500,000원) - ", 1500000),
    MATCH_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    MATCH_SIX("6개 일치 (2,000,000,000원) - ",2000000000);

    private final String message;
    private final Integer prize;

    MATCHING(String message, Integer prize) {

        this.message = message;
        this.prize = prize;
    }

    public String getMessage(Integer count) {

        return this.message + count + "개";
    }

    public Integer getPrize() {

        return this.prize;
    }
}
