package lotto;

import static lotto.StringResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.StringResourceProvider.PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_INTEGER_TEXT;
import static lotto.StringResourceProvider.PURCHASE_AMOUNT_CANNOT_CONVERT_TO_INTEGER_TEXT;
import static lotto.StringResourceProvider.PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println(INPUT_PURCHASE_AMOUNT_TEXT);

        try{
            int purchaseAmount = Integer.parseInt(Console.readLine());
            if(purchaseAmount < 0){
                throw new UserInvalidInputException(PURCHASE_AMOUNT_CANNOT_CONVERT_TO_INTEGER_TEXT);
            }
            if(purchaseAmount % 1000 != 0 || purchaseAmount == 0){
                throw new UserInvalidInputException(PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_INTEGER_TEXT);
            }
        }
        catch (NumberFormatException e){
            throw new UserInvalidInputException(PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_PURCHASE_AMOUNT, e);
        }
    }
}
