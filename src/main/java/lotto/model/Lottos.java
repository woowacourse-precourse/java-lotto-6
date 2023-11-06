package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoConstants;
import lotto.view.InputView;

public class Lottos {
    LottoConstants purchasePrice = LottoConstants.PURCHASE_PRICE;

    public Lottos(String purchaseAmount){
        int inputPrice = Integer.parseInt(purchaseAmount);
        purchaseAmountvalidate(inputPrice);
    }

    public void purchaseAmountvalidate(int inputPrice) throws IllegalArgumentException{
        IsInputPriceDividedPurchasePrice(inputPrice);
        IsNotZero(inputPrice);
    }

    public boolean IsInputPriceDividedPurchasePrice(int inputPrice){
        if(inputPrice % purchasePrice.getValue() != 0){
           throw new IllegalArgumentException();
        }

        return true;
    }
    public boolean IsNotZero(int inputPrice){
        if(inputPrice == 0){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
