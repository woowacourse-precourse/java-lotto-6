package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Messages.ErrorMessage;
import lotto.Messages.MainMessage;

public class Input {
    public static enum InputType{
        PURCHASE_AMOUNT, WINNING_NUMBERS, BONUS_NUMBER;
    }

    public List<Integer> input(InputType inputtype){
        String inputStr;
        List<Integer> inputResult;
        Print.printInputMessage(inputtype);
        do {
            inputStr = Utils.input();
            inputResult = inputTypeSelect(inputStr, inputtype);
        } while (inputResult == null);
        return inputResult;
    }

    private List<Integer> inputTypeSelect(String inputStr, InputType inputType){
        List<Integer> conversionResult = new ArrayList<>();
        try{
            if (inputType == InputType.PURCHASE_AMOUNT){
                conversionResult = purchaseAmountInput(inputStr);
            }
            if (inputType == InputType.BONUS_NUMBER){
                conversionResult = bonusNumberInput(inputStr);
            }
            if (inputType == InputType.WINNING_NUMBERS){
                conversionResult = winningNumbersInput(inputStr);
            }
        }catch(IllegalArgumentException e){
            return null;
        }
        return conversionResult;
    }

    public List<Integer> purchaseAmountInput(String inputStr){
        List<Integer> conversionResult = new ArrayList<>();
        purchaseAmountValidate(inputStr);
        conversionResult.add(Integer.parseInt(inputStr));
        return conversionResult;
    }
    private void purchaseAmountValidate(String inputStr){
        if (inputStr.isEmpty()){
            Print.printMessage(ErrorMessage.NULL_STRING.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
        }
        if (Utils.isNumeric(inputStr) == false) {
            Print.printMessage(ErrorMessage.NON_NUMERIC_STR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_STR.getMessage());
        }
        if (Integer.parseInt(inputStr) % 1000 != 0){
            Print.printMessage(ErrorMessage.NOT_DIVIED_1000.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIED_1000.getMessage());
        }
    }

    public List<Integer> bonusNumberInput(String inputStr){
        List<Integer> conversionResult = new ArrayList<>();
        bonusNumberValidate(inputStr);
        conversionResult.add(Integer.parseInt(inputStr));
        return conversionResult;
    }

    private void bonusNumberValidate(String inputStr){
        if (inputStr.isEmpty()){
            Print.printMessage(ErrorMessage.NULL_STRING.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
        }
        if (Utils.isNumeric(inputStr) == false){
            Print.printMessage(ErrorMessage.NON_NUMERIC_STR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_STR.getMessage());
        }
        if (Integer.parseInt(inputStr) < 1 || 45 < Integer.parseInt(inputStr)){
            Print.printMessage(ErrorMessage.NOT_IN_1_TO_45.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_1_TO_45.getMessage());
        }
    }

    public List<Integer> winningNumbersInput(String inputStr){
        List<Integer> conversionResult = new ArrayList<>();
        winningNumberValidate(inputStr, inputStr.split(","));
        for (String splited : inputStr.split(",")){
            conversionResult.add(Integer.parseInt(splited));
        }
        return conversionResult;
    }

    private void winningNumberValidate(String inputStr, String[] splitStr){
        if (inputStr.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
        }
        if (inputStr.charAt(0) == ',' || inputStr.charAt(inputStr.length() - 1) == ','){
            throw new IllegalArgumentException(ErrorMessage.ILLIGAL_COMMA.getMessage());
        }
        for (String splited : splitStr){
            if (splited.isEmpty()){
                throw new IllegalArgumentException(ErrorMessage.ILLIGAL_COMMA.getMessage());
            }
            if (Utils.isNumeric(splited) == false){
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_STR.getMessage());
            }
            if (Integer.parseInt(splited) < 1 || 45 < Integer.parseInt(splited)){
                throw new IllegalArgumentException(ErrorMessage.NOT_IN_1_TO_45.getMessage());
            }
        }
    }
}
