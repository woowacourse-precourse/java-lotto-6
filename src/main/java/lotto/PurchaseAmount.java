package lotto;

import static camp.nextstep.edu.missionutils.Console.*;
import static constant.LottoValue.*;
import static exception.ExceptionMessage.*;
import static output.InputMessage.GIVE_THE_PURCHASE_AMOUNT;

public class PurchaseAmount {
    int purchaseAmount;

    public PurchaseAmount(){}

    public int input() {
        System.out.println(GIVE_THE_PURCHASE_AMOUNT.message());
        String input = readLine();
        try{
            validateAmount(validateInteger(input));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            input();
        }
        return purchaseAmount/ THOUSAND.value();
    }

    private int validateInteger(String input) {
        try{
            purchaseAmount = Integer.parseInt(input);
            return purchaseAmount;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_STRING.message());
        }
    }

    private void validateAmount(int purchaseAmount){
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_REMAIN.message());
        }
        if(purchaseAmount > AMOUNT_UPPER_LIMIT.value()){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_OVERFLOW.message());
        }
        if(purchaseAmount < AMOUNT_LOWER_LIMIT.value()){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NEGATIVE_NUMBER.message());
        }
    }
}
