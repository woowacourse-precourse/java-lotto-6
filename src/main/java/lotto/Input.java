package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int inputPurchaseAmount(){
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private void validatePurchaseAmount(String purchaseAmount){
        int temp;
        if(purchaseAmount.isBlank()){
            throw new IllegalArgumentException();
        }
        try{
           temp = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if ((temp / 1000) != 0) {
            throw new IllegalArgumentException();
        }
    }
}
