package lotto;

public enum LotteryWinOption {

        FIRST_PLACE(2000000000, "6개 일치 (2,000,000,000원)", 6),
        SECOND_PLACE(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)", 7),
        THIRD_PLACE(1500000, "5개 일치 (1,500,000원)", 5),
        FOURTH_PLACE(50000, "4개 일치 (50,000원)", 4),
        FIFTH_PLACE(5000, "3개 일치 (5,000원)", 3),
        LOSE(0, "2개 이하 일치", 0);

        private final Integer prizeAmount;
        private final String message;
        private final Integer numberCount;

        LotteryWinOption(Integer prizeAmount, String message, Integer numberCount) {
                this.prizeAmount = prizeAmount;
                this.message = message;
                this.numberCount = numberCount;
        }

        public int getPrizeAmount() {
                return prizeAmount;
        }

        public String getMessage() {
                return message;
        }

}
