package lotto.domain;

public class Player {
    private static final int AMOUNT_UNIT = 1_000;
    private PlayerBuyPrice playerBuyPrice;

    public Player(final String amount) {
        this.playerBuyPrice = new PlayerBuyPrice(amount);
    }

    public int getPlayerBuyPrice() {
        return Integer.parseInt(playerBuyPrice.amount());
    }

    public int getPlayerTicketQuantity(){
        return Integer.parseInt(playerBuyPrice.amount()) / AMOUNT_UNIT;
    }
}
