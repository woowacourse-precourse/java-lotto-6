package lotto;

public class Buyer {
    private int amount;

    public Buyer(){
        String amountInput = BuyerInfoInput.inputPurchaseAmount();
        validateAmount(amountInput);
        this.amount = Integer.parseInt(amountInput);
    }

    public void validateAmount(String amount){
        Validator.isValidAmount(amount);
        Validator.isAmountDivisibleBy1000(amount);
    }

}
