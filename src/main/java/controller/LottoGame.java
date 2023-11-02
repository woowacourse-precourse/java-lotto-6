package controller;

public class LottoGame {
    private int lottoQuantity;

    public LottoGame(String amount) throws IllegalArgumentException{
        char[] money = amount.toCharArray();
        for(char c : money)
        {
            validateDigit(c);
        }
        int inputMoney = Integer.parseInt(amount);
        validateRemainder(inputMoney);
        inputMoney /= 1000;
        this.lottoQuantity = inputMoney;
        System.out.println("lottoQuantity is "+this.lottoQuantity);
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }

    private void validateDigit(char c){
        if(!Character.isDigit(c)){
            throw new IllegalArgumentException("[ERROR] 숫자로만 입력해 주세요.");
        }
    }
    private void validateRemainder(int money) throws IllegalArgumentException{
        if((money%1000) != 0){
            throw new IllegalArgumentException("[ERROR] 금액이 1000원으로 나누어 떨어지지 않아요.");
        }
    }
}
