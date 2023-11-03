package lotto.service;

public class Exceptions {
    public void isInvalidPurchaseMoneyAmount(int money, int divided){
        if(money % divided != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원단위로 가능합니다.");
        }
    }
}
