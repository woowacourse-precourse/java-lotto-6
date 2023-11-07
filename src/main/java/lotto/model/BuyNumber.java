package lotto.model;

public class BuyNumber {

    private int money;
    private int gameCount;

    public BuyNumber(int money){
        this.money=money;
        this.gameCount=money/1000;
    }

    public int getGameCount() {
        return gameCount;
    }

}
