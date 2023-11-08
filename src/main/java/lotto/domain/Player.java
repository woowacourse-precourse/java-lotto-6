package lotto.domain;

public class Player {
    private PlayerBuyPrice playerBuyPrice;

    public Player(final String amount) {
        this.playerBuyPrice = new PlayerBuyPrice(amount);
    }

    public int getPlayerBuyPrice() {
        return Integer.parseInt(playerBuyPrice.amount());
    }
}
