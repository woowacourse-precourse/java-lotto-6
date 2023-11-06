package lotto.Model;

public class CheckPurchaseAmount {

    private int getNumberOfTicket(int purchaseAmount){
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount%1000;
    }

    private void validatePurchaseAmount(int purchaseAmount){
        if(purchaseAmount%1000==0){
            throw new IllegalArgumentException();
        }
    }    
}
