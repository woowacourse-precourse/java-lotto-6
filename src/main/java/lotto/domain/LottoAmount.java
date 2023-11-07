package lotto.domain;

import static lotto.view.InputView.inputLottoAmount;

public class LottoAmount {
    private static int price=0;
    public LottoAmount(){
        purchaseAmountValidate();
        System.out.println(howManyLotto(price));
    }
    private static void lottoPrice() {
        String purchaseAmount = inputLottoAmount();
        System.out.println();
        price = Integer.parseInt(purchaseAmount);
        purchaseAmount(price);
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
    public static Integer priceCalculation(int amount){
        return amount/1000;
    }

    public static String howManyLotto(int amount){
        return priceCalculation(amount)+"개를 구매했습니다.";
    }
}
