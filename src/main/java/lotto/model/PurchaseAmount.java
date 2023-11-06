package lotto.model;

public class PurchaseAmount {

    public int convertAmountToGames(String amount) {
        int games = Integer.parseInt(amount) / 1000;
        return games;
    }
}
