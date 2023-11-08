package lotto.model;

public class BuyingMoney {
    public int buyingMoney;

    public BuyingMoney(String buyingMoney) {
        inputBuyingMoneyValidate(buyingMoney);
        this.buyingMoney = Integer.parseInt(buyingMoney);
    }
    public void inputBuyingMoneyValidate(String s){
        inputBuyingMoneyValidateOnlyNum(s);
        inputBuyingMoneyValidateDivided1000(s);
    }

    private void inputBuyingMoneyValidateOnlyNum(String s) {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    private void inputBuyingMoneyValidateDivided1000(String s) {
        int i = Integer.parseInt(s);
        if(i%1000!=0){
            throw new IllegalArgumentException();
        }
    }
}
