package lotto;

public class LottoPurchaseMoney {

    private int money;

    public LottoPurchaseMoney(String inputMoney) {
        int money = Converter.stringToInt(inputMoney);
        this.money = money;
    }

}
