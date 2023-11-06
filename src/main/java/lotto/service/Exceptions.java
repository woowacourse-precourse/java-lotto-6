package lotto.service;

public class Exceptions {
    public void isInvalidPurchaseMoneyAmount(int money, int divided){
        if(money % divided != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원단위로 가능합니다.");
        }
    }

    public void isInvalidNumberOfLotteries(String input){
        String[] lotteries  = input.split(",");
        if(lotteries.length != 6){
            throw new IllegalArgumentException("로또 번호는 6개를 입력해주셔야 합니다.");
        }
    }
}
