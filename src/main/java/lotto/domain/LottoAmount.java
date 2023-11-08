package lotto.domain;

import static lotto.view.ExceptionMessage.divisibleException;
import static lotto.view.InputView.inputLottoAmount;

public class LottoAmount {
    private static final int AMOUNT_UNIT=1000;
    private static int price=0;

    private static void lottoPrice() {
        price = Integer.parseInt(inputLottoAmount());
        System.out.println();
        purchaseAmount(price);
    }

    public static void purchaseAmount(int amount) throws IllegalArgumentException{
        if (amount % AMOUNT_UNIT != 0){
            throw new IllegalArgumentException();
        }
    }

    public static void purchaseAmountValidate(){
        try{
            lottoPrice();
        }catch(IllegalArgumentException e){
            divisibleException();
            lottoPrice();
        }
    }
    public static Integer priceCalculation(){
        return price/1000;
    }
}
