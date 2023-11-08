package lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private final Validater validater = new Validater();
    private Lotto winningNumber;
    public enum InputType{
        PURCHASE_AMOUNT, WINNING_NUMBERS, BONUS_NUMBER;
    }

    public List<Integer> input(InputType inputType){
        String inputStr;
        List<Integer> inputResult;
        Print.printInputMessage(inputType);
        do {
            inputStr = Utils.input();
            inputResult = inputTypeSelect(inputStr, inputType);
        } while (inputResult == null);
        return inputResult;
    }
    private List<Integer> inputTypeSelect(String userInput, InputType inputType){
        List<Integer> conversionResult = new ArrayList<>();
        try{
            if (inputType == InputType.PURCHASE_AMOUNT){
                conversionResult = purchaseAmountInput(userInput);
            }
            if (inputType == InputType.BONUS_NUMBER){
                conversionResult = bonusNumberInput(userInput);
            }
            if (inputType == InputType.WINNING_NUMBERS){
                conversionResult = winningNumbersInput(userInput);
            }
        }catch(IllegalArgumentException e){
            return null;
        }
        return conversionResult;
    }

    public List<Integer> purchaseAmountInput(String purchaseInput){
        List<Integer> conversionResult = new ArrayList<>();
        validater.inputValidation(InputType.PURCHASE_AMOUNT, purchaseInput);
        conversionResult.add(Integer.parseInt(purchaseInput));
        return conversionResult;
    }
    public List<Integer> bonusNumberInput(String bonusInput){
        List<Integer> conversionResult = new ArrayList<>();
        validater.inputValidation(InputType.BONUS_NUMBER, bonusInput);
        validater.numberIsContainedCheck(winningNumber, Integer.parseInt(bonusInput));
        conversionResult.add(Integer.parseInt(bonusInput));
        return conversionResult;
    }
    public List<Integer> winningNumbersInput(String winningInput){
        List<Integer> conversionResult = new ArrayList<>();
        validater.inputValidation(InputType.WINNING_NUMBERS, winningInput);
        for (String splited : winningInput.split(",")){
            conversionResult.add(Integer.parseInt(splited));
        }
        winningNumber = new Lotto(conversionResult);
        return conversionResult;
    }
}