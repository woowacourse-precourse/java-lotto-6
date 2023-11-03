package view.constant;

public enum ConstantMoney {

    THREE_MATCHES_MONEY(5000),
    FOUR_MATCHES_MONEY(50000),
    FIVE_MATCHES_MONEY(1500000),
    FIVE_BONUS_MATCHES_MONEY(30000000),
    SIX_MATCHES_MONEY(2000000000);


    private final int money;

    ConstantMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }
}
