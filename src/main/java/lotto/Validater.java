package lotto;

import java.util.List;
import lotto.Input.InputType;
import lotto.Messages.ErrorMessage;

public class Validater {
    private static final String DIVIDING_POINT = ",";

    public void inputValidation(InputType inputType, String inputStr){
        if (inputType == InputType.PURCHASE_AMOUNT){
            purchaseAmountValidate(inputStr);
        }
        if (inputType == InputType.BONUS_NUMBER){
            bonusNumberValidate(inputStr);
        }
        if (inputType == InputType.WINNING_NUMBERS){
            winningNumberValidate(inputStr);
        }
    }
    private void purchaseAmountValidate(String inputStr){
        strEmptyCheck(inputStr);
        strNumericCheck(inputStr);
        if (Integer.parseInt(inputStr) % Lotto.LOTTO_PRICE != 0 || Integer.parseInt(inputStr) == 0){
            Print.printMessage(ErrorMessage.NOT_DIVIED_1000.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIED_1000.getMessage());
        }
    }
    private void bonusNumberValidate(String inputStr){
        strEmptyCheck(inputStr);
        strNumericCheck(inputStr);
        if (Integer.parseInt(inputStr) < Lotto.LOTTO_MIN_VALUE || Lotto.LOTTO_MAX_VALUE < Integer.parseInt(inputStr)){
            Print.printMessage(ErrorMessage.NOT_IN_1_TO_45.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_1_TO_45.getMessage());
        }
    }
    private void winningNumberValidate(String inputStr){
        strEmptyCheck(inputStr);
        strNumericCheck(inputStr, List.of(DIVIDING_POINT));
        strSplitedCheck(inputStr, DIVIDING_POINT);
    }

    private void strEmptyCheck(String str){
        if (str.isEmpty()){
            Print.printMessage(ErrorMessage.NULL_STRING.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
        }
    }
    private void strNumericCheck(String str){
        if (Utils.isNumeric(str) == false) {
            Print.printMessage(ErrorMessage.NON_NUMERIC_STR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_STR.getMessage());
        }
    }
    private void strNumericCheck(String str, List<String> toExclude){
        if (Utils.isNumeric(str, toExclude) == false) {
            Print.printMessage(ErrorMessage.NON_NUMERIC_STR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_STR.getMessage());
        }
    }
    private void strSplitedCheck(String str, String regex){
        if (str.startsWith(regex) == true || str.endsWith(regex) == true){
            Print.printMessage(ErrorMessage.ILLIGAL_DIVIDING.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ILLIGAL_DIVIDING.getMessage());
        }
        for (String splited : str.split(regex)){
            if (splited.isEmpty()){
                Print.printMessage(ErrorMessage.ILLIGAL_DIVIDING.getMessage());
                throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
            }
        }
    }
}
