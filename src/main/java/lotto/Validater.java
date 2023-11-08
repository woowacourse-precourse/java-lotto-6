package lotto;

import java.util.List;
import lotto.Input.InputType;
import lotto.Messages.ErrorMessage;

public class Validater {
    private static final String DIVIDING_POINT = ",";

    public void inputValidation(InputType inputType, String userInput){
        if (inputType == InputType.PURCHASE_AMOUNT){
            purchaseAmountValidate(userInput);
        }
        if (inputType == InputType.BONUS_NUMBER){
            bonusNumberValidate(userInput);
        }
        if (inputType == InputType.WINNING_NUMBERS){
            winningNumberValidate(userInput);
        }
    }
    private void purchaseAmountValidate(String purchaseInput){
        strEmptyCheck(purchaseInput);
        strNumericCheck(purchaseInput);
        if (Integer.parseInt(purchaseInput) % Lotto.LOTTO_PRICE != 0 || Integer.parseInt(purchaseInput) == 0){
            Print.printMessage(ErrorMessage.NOT_DIVIED_1000.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIED_1000.getMessage());
        }
    }
    private void bonusNumberValidate(String bonusInput){
        strEmptyCheck(bonusInput);
        strNumericCheck(bonusInput);
        if (Integer.parseInt(bonusInput) < Lotto.LOTTO_MIN_VALUE || Lotto.LOTTO_MAX_VALUE < Integer.parseInt(bonusInput)){
            Print.printMessage(ErrorMessage.NOT_IN_1_TO_45.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_1_TO_45.getMessage());
        }
    }
    private void winningNumberValidate(String winningInput){
        strEmptyCheck(winningInput);
        strNumericCheck(winningInput, List.of(DIVIDING_POINT));
        strSplitedCheck(winningInput, DIVIDING_POINT);
    }

    private void strEmptyCheck(String testValue){
        if (testValue.isEmpty()){
            Print.printMessage(ErrorMessage.NULL_STRING.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
        }
    }
    private void strNumericCheck(String testValue){
        if (Utils.isNumeric(testValue) == false) {
            Print.printMessage(ErrorMessage.NON_NUMERIC_STR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_STR.getMessage());
        }
    }
    private void strNumericCheck(String testValue, List<String> excludedWords){
        if (Utils.isNumeric(testValue, excludedWords) == false) {
            Print.printMessage(ErrorMessage.NON_NUMERIC_STR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_STR.getMessage());
        }
    }
    private void strSplitedCheck(String testValue, String regex){
        if (testValue.startsWith(regex) == true || testValue.endsWith(regex) == true){
            Print.printMessage(ErrorMessage.ILLIGAL_DIVIDING.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ILLIGAL_DIVIDING.getMessage());
        }
        for (String splited : testValue.split(regex)){
            if (splited.isEmpty()){
                Print.printMessage(ErrorMessage.ILLIGAL_DIVIDING.getMessage());
                throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
            }
        }
    }
    public void numberIsContainedCheck(Lotto numbers, Integer checkNumber){
        if (numbers.isContains(checkNumber)){
            Print.printMessage(ErrorMessage.DUPLICATED_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
    }
}
