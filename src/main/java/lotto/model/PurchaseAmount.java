package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorMessages;
import lotto.util.LottoRules;

public class PurchaseAmount {

    private String ERROR_MESSAGE_PURCHASE_AMOUNT = ErrorMessages.ERROR_MESSAGE_PURCHASE_AMOUNT.getMessage();
    int pricePerLotto = LottoRules.PRICE_PER_LOTTO.getValue();
    int purchaseAmount;
    int purchaseCount;

    public PurchaseAmount() {
    }

    public void generateLottoCount(){
        while(true){
            try{
                int inputPrice = Integer.parseInt(askPurchaseAmount());
                validatePurchaseAmount(inputPrice);
                this.purchaseAmount = inputPrice;
                this.purchaseCount = calculateLottoCount(inputPrice);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE_PURCHASE_AMOUNT);
            }
        }
    }

    private String askPurchaseAmount() {
        return Console.readLine();
    }


    private void validatePurchaseAmount(int inputPrice) {
        IsInputPriceDividedPurchasePrice(inputPrice);
        IsNotZero(inputPrice);
    }


    public boolean IsInputPriceDividedPurchasePrice(int inputPrice) throws IllegalArgumentException {
        if (inputPrice % pricePerLotto != 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public boolean IsNotZero(int inputPrice) throws IllegalArgumentException {
        if (inputPrice == 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int calculateLottoCount(int inputPrice) {
        return (inputPrice / pricePerLotto);
    }

}
