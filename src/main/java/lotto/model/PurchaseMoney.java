package lotto.model;

public class PurchaseMoney {
    private int value;

    public PurchaseMoney(int money){
        this.value = money;
    }

    private void validate(String money){
        if(!isDigit(money)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isDigit(String money){
        for (int i = 0; i < money.length(); i++) {
            if(!Character.isDigit(money.charAt(i))) return false;
        }

        return true;
    }
}
