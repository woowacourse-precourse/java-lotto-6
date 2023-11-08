package lotto;

public class PlaceAndPrize {
    public enum Place {
        firstPlace(6, 2000000000), secondPlace(5, 30000000), thridPlace(5, 1500000),
        forthPlace(4, 50000), fifthPlace(3, 5000);

        private final int matchPlace;
        private final int prizeAmount;

        Place(int matchPlace, int prizeAmount) {
            this.matchPlace = matchPlace;
            this.prizeAmount = prizeAmount;
        }

        public int getMatchPlace() {
            return matchPlace;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }
}
