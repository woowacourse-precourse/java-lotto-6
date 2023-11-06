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
        String inputStr = Utils.input();
        List<Integer> inputResult;
        System.out.println(MainMessage.INPUT_PURCHASE_AMOUNT);
        do {
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
            /*
            if (inputType == InputType.WINNING_NUMBERS){
                conversionResult = winningNumbersInput(inputStr);
            }
            */
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
            throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
        }
        for (int i = 0; i < inputStr.length(); i++) {
            if (Utils.isNumeric(inputStr.charAt(i)) == false) {
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_CHAR.getMessage());
            }
        }
        if (Integer.parseInt(inputStr) % 1000 != 0){
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
            throw new IllegalArgumentException(ErrorMessage.NULL_STRING.getMessage());
        }
        for (int i = 0; i < inputStr.length(); i++) {
            if (Utils.isNumeric(inputStr.charAt(i)) == false) {
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_CHAR.getMessage());
            }
        }
        if (Integer.parseInt(inputStr) < 1 || 45 < Integer.parseInt(inputStr)){
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_1_TO_45.getMessage());
        }
    }
    /*
    public List<Integer> winningNumbersInput(String inputStr){

    }
    public List<Integer> bonusNumberInput(String inputStr){

    }
    */
}
