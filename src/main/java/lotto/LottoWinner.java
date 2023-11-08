package lotto;

public class LottoWinner {
    private enum LottoResult {
        FIRST(1, 2000000000, "6개 일치 (2,000,000,000원)"),
        SECOND(2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
        THIRD(3, 1500000, "5개 일치 (1,500,000원)"),
        FOURTH(4, 50000, "4개 일치 (50,000원)"),
        FIFTH(5, 5000, "3개 일치 (5,000원)");

        private int rank;
        private int winnerCount;
        private int prizeMoney;
        private String message;

        LottoResult(int rank, int prizeMoney, String message) {
            this.rank = rank;
            this.winnerCount = 0;
            this.prizeMoney = prizeMoney;
            this.message = message;
        }

        public void increaseWinnerCount() {
            this.winnerCount++;
        }

        public void increasePrizeMoney() {
            this.prizeMoney = prizeMoney * winnerCount;
        }

        public int getWinnerCount() {
            return winnerCount;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }

        public String getMessage() {
            return message;
        }

        public void setWinnerAndPrize() {
            increaseWinnerCount();
            increasePrizeMoney();
        }

        public static LottoResult getLottoResultByRank(int rank) {
            for (LottoResult result : values()) {
                if (result.rank == rank) {
                    return result;
                }
            }
            return null;
        }
    }

    public void updateWinnerAndPrize(int rank) {
        LottoResult result = LottoResult.getLottoResultByRank(rank);
        if (result != null) {
            result.setWinnerAndPrize();
        }
    }

    public void printLottoResult(int rank) {
        LottoResult result = LottoResult.getLottoResultByRank(rank);
        if (result != null) {
            System.out.println(result.getMessage() + " - " + result.getWinnerCount() + "개");
        }
    }

    public double getPrizeMoney(int rank) {
        LottoResult result = LottoResult.getLottoResultByRank(rank);
        if (result != null && result.getWinnerCount() > 0) {
            return result.getPrizeMoney();
        }
        return 0;
    }

}
