package lotto;

import static camp.nextstep.edu.missionutils.Console.*;
import static exception.ExceptionMessage.*;

public class PurchaseAmount {

    private static final int AMOUNT_UPPER_LIMIT = 2000000000;
    private static final int AMOUNT_LOWER_LIMIT = 0;

    int purchaseAmount;

    public PurchaseAmount(){}

    public int input() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try{
            validateAmount(validateInteger(input));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            input();
        }
        return purchaseAmount/1000;
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
        if(purchaseAmount > AMOUNT_UPPER_LIMIT){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_OVERFLOW.message());
        }
        if(purchaseAmount < AMOUNT_LOWER_LIMIT){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NEGATIVE_NUMBER.message());
        }
    }
}
