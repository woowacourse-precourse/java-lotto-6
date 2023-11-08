package lotto.domain;

import java.util.regex.Pattern;
import lotto.message.ExceptionMessage;

public class Amount {
    private static final String AMOUNT_REGEXP = "^[0-9]+$";
    private final int AMOUNT_MIN = 1000;
    private final int amount;
    private final int countLotto;

    public Amount(String input){
        validateInput(input);
        int amount = parseAmount(input);
        validateMin(amount);
        validateDivision(amount);

        this.amount = amount;
        this.countLotto = calculatePurchaseCount(amount);
    }

    private void validateInput(String input){
        if(!Pattern.matches(AMOUNT_REGEXP,input)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_TYPE.getMessage());
        }
    }

    private void validateMin(int amount) {
        if (amount<AMOUNT_MIN) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_MIN.getMessage());
        }
    }

    private void validateDivision(int amount){
        if(amount%AMOUNT_MIN != 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_DIVISION.getMessage());
        }
    }

    public int parseAmount(String input){
        return Integer.parseInt(input);
    }

    public int calculatePurchaseCount(int amount){
        return amount/AMOUNT_MIN;
    }

<<<<<<< HEAD
=======
    public int getAmount(){
        return amount;
    }
>>>>>>> parent of 767be5b (Refactor: 우테코 코드 컨벤션에 맞게 코드 수정)

    public int getCountLotto(){
        return countLotto;
    }
}
