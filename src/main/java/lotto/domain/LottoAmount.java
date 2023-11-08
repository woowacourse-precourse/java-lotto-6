package lotto.domain;

import static lotto.view.InputView.inputLottoAmount;

public class LottoAmount {
    private static int price=0;
    public LottoAmount(){
        purchaseAmountValidate();
    }
    private static void lottoPrice() {
        price = inputNumberChange();
        System.out.println();
        purchaseAmount(price);
    }
    private static Integer inputNumberChange(){
        String purchaseAmount = inputLottoAmount();
        return Integer.parseInt(purchaseAmount);
    }

    public static void purchaseAmount(int amount) throws IllegalArgumentException{
        if (amount % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    private static void purchaseAmountValidate(){
        try{
            lottoPrice();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR]로또 금액은 1000원 단위로 사용해야 합니다.");
            lottoPrice();
        }
    }
    public static Integer priceCalculation(int num){
        return num/1000;
    }


}
