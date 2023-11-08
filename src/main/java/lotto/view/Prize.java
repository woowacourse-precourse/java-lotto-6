package lotto.view;
import lotto.view.Amount;

public enum Prize {
        THREE_MATCH(Amount.AMOUNT_1, 0, "3개 일치 (5,000원) - %d개"),
        FOUR_MATCH(Amount.AMOUNT_2, 0, "4개 일치 (50,000원) - %d개"),
        FIVE_MATCH(Amount.AMOUNT_3, 0, "5개 일치 (1,500,000원) - %d개"),
        FIVE_MATCH_WITH_BONUS(Amount.AMOUNT_4, 0, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
        SIX_MATCH(Amount.AMOUNT_5, 0, "6개 일치 (2,000,000,000원) - %d개");

        private final Amount amount;
        private final int numberOfWinners;
        private final String prizeDescription;

        Prize(Amount amount, int numberOfWinners, String prizeDescription) {
            this.amount = amount;
            this.numberOfWinners = numberOfWinners;
            this.prizeDescription = prizeDescription;
        }


        public String generatePrizeString(int numberOfMatches) {
            return String.format(prizeDescription, numberOfMatches);
        }

}
