package lotto.service;

public class Exceptions {
    public void  isInvalidPurchaseAmount(String money){
        try {
            int intMoney = Integer.parseInt(money);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력 가능합니다.");
        }
    }
}
