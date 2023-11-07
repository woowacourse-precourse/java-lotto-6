package lotto.domain;

public enum Ranking { //로또 등수 enum
    MISS(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),

    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    Ranking(Integer matching, Integer reward, String message) {
        this.matching = matching;
        this.reward = reward;
        this.message = message;
    }

    private final Integer matching;
    private final Integer reward;
    private final String message;

    public static Ranking calculator(Integer matching, boolean matchBonus) {
        if (matching < 3) {
            return MISS;
        }

        if (SECOND.matchCount(matching) && matchBonus) {
            return SECOND;
        }

        for (Ranking rank : values()) {
            if (rank.matchCount(matching) && rank != SECOND) {
                return rank;
            }
        } throw new IllegalArgumentException("[ERROR] 오류가 발생했습니다.");
    }

    public int getRevenue() {
        return reward;
    }

    private boolean matchCount(int number) {
        return this.matching == number;
    }

    public void printMessage(int count) {
        if (this != MISS) {
            System.out.println(message + count + "개");
        }
    }
//    public int getCountOfMatch() {
//        return this.countOfMatch;
//    }
}

