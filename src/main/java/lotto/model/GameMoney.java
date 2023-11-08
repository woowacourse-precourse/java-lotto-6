package lotto.model;

public class GameMoney {

    private int money;
    private int gameCount;

    public GameMoney(int money){
        this.money=money;
        this.gameCount=money/1000;
    }

    public int getGameCount() {
        return gameCount;
    }

    public int getMoney(){
        return money;
    }

}
