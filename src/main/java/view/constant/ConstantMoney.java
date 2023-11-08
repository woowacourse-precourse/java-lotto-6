package view.constant;

public enum ConstantMoney {

    THREE_MATCHES_MONEY_INT(5000),
    FOUR_MATCHES_MONEY_INT(50000),
    FIVE_MATCHES_MONEY_INT(1500000),
    FIVE_BONUS_MATCHES_MONEY_INT(30000000),
    SIX_MATCHES_MONEY_INT(2000000000);


    private final int money;

    private static final ConstantMoney[] LottoResultMoney = {
            THREE_MATCHES_MONEY_INT, FOUR_MATCHES_MONEY_INT, FIVE_MATCHES_MONEY_INT, FIVE_BONUS_MATCHES_MONEY_INT,SIX_MATCHES_MONEY_INT
    };

    public static int getLottoResultMoney(int i) {
        return LottoResultMoney[i].getMoney();
    }

    ConstantMoney(int money){
        this.money = money;
    }

    public int getMoney(){
        return money;
    }
}
