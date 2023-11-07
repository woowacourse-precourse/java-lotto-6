package lotto;

public class BuyLotto {
    public final int buyMoney;

    public BuyLotto(int buyMoney) {
        this.buyMoney = buyMoney;
    }

    private int vaildMoney(int buyMoney){
        if(buyMoney%1000 !=0) {
            throw new IllegalArgumentException();
        }
        return buyMoney%1000;
    }
}
