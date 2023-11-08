package lotto;

public class Rank {

    public enum Prize {
        FIFTH(5000, 3, false, "3개 일치"),
        FOURTH(50000, 4, false, "4개 일치"),
        THIRD(1500000, 5, false, "5개 일치"),
        SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치"),
        FIRST(2000000000, 6, false, "6개 일치");

        private int prizeAmount;
        private int matchCount;
        private boolean hasBonus;
        private String message;

        Prize(int prizeAmount, int matchCount, boolean hasBonus, String message) {
            this.prizeAmount = prizeAmount;
            this.matchCount = matchCount;
            this.hasBonus = hasBonus;
            this.message = message;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public boolean hasBonus() {
            return hasBonus;
        }

        public String getMessage() {
            return message;
        }
    }

}
