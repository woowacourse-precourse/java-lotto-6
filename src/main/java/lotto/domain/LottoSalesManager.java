package lotto.domain;

import lotto.ErrorMessages;

public class LottoSalesManager {
    private final int amount;

    public LottoSalesManager(String unParsedAmount) {
        checkIsValid(unParsedAmount);
        this.amount = Integer.parseInt(unParsedAmount);
    }

    private void checkIsValid(String unParsedAmount) {
        int parsedAmount = 0;
        try{
            parsedAmount = Integer.parseInt(unParsedAmount);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(ErrorMessages.CAN_NOT_CONVERT_TO_NUMBER.getMessage());
        }

        if(parsedAmount % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessages.NOT_A_MULTIPLE_OF_1000.getMessage());
        }
    }

}
