package lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private final Validater validater = new Validater();
    private Lotto winningNumber;
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
        validater.inputValidation(InputType.PURCHASE_AMOUNT, inputStr);
        conversionResult.add(Integer.parseInt(inputStr));
        return conversionResult;
    }
    public List<Integer> bonusNumberInput(String inputStr){
        List<Integer> conversionResult = new ArrayList<>();
        validater.inputValidation(InputType.BONUS_NUMBER, inputStr);
        conversionResult.add(Integer.parseInt(inputStr));
        return conversionResult;
    }
    public List<Integer> winningNumbersInput(String inputStr){
        List<Integer> conversionResult = new ArrayList<>();
        validater.inputValidation(InputType.WINNING_NUMBERS, inputStr);
        for (String splited : inputStr.split(",")){
            conversionResult.add(Integer.parseInt(splited));
        }
        winningNumber = new Lotto(conversionResult);
        return conversionResult;
    }
}