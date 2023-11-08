package lotto;

public class Win {
    enum WinningRank {
        THREE_MATCH("3개 일치", 5_000),
        FOUR_MATCH("4개 일치", 50_000),
        FIVE_MATCH("5개 일치", 1_500_000),
        FIVE_PLUS_BONUS("5개 일치, 보너스 볼 일치", 30_000_000),
        SIX_MATCH("6개 일치", 2_000_000_000);

        private final String description;
        private final int prizeMoney;

        WinningRank(String description, int prizeMoney) {
            this.description = description;
            this.prizeMoney = prizeMoney;
        }

        public String getDescription() {
            return description;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }
    }
}
