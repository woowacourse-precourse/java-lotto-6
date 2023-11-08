package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.Input.InputType;
import lotto.Messages.ErrorMessage;

public class Validater {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;
    private static final int MAX_LOTTO_SIZE = 6;
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
        if (Integer.parseInt(inputStr) % LOTTO_PRICE != 0){
            Print.printMessage(ErrorMessage.NOT_DIVIED_1000.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIED_1000.getMessage());
        }
    }
    private void bonusNumberValidate(String inputStr){
        strEmptyCheck(inputStr);
        strNumericCheck(inputStr);
        if (Integer.parseInt(inputStr) < 1 || 45 < Integer.parseInt(inputStr)){
            Print.printMessage(ErrorMessage.NOT_IN_1_TO_45.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_1_TO_45.getMessage());
        }
    }
    private void winningNumberValidate(String inputStr){
        strEmptyCheck(inputStr);
        strNumericCheck(inputStr, List.of(DIVIDING_POINT));
        strSplitedCheck(inputStr, DIVIDING_POINT);
        dividingSizeCheck(inputStr.split(DIVIDING_POINT), MAX_LOTTO_SIZE);
        if (Arrays.stream(inputStr.split(DIVIDING_POINT)).distinct().count() != inputStr.split(DIVIDING_POINT).length){
            Print.printMessage(ErrorMessage.DUPLICATED_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
        }
        for (String splited : inputStr.split(DIVIDING_POINT)){
            System.out.println(splited);
            if (Integer.parseInt(splited) < LOTTO_MIN_VALUE || LOTTO_MAX_VALUE < Integer.parseInt(splited)){
                Print.printMessage(ErrorMessage.NOT_IN_1_TO_45.getMessage());
                throw new IllegalArgumentException(ErrorMessage.NOT_IN_1_TO_45.getMessage());
            }
        }
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

    private void dividingSizeCheck(String[] splited, int checkSize){
        if (splited.length != checkSize){
            Print.printfMessage(ErrorMessage.SIZE_OVER.getMessage(), checkSize);
            throw new IllegalArgumentException(ErrorMessage.SIZE_OVER.getMessage());
        }
    }
}
