package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Messages.ErrorMessage;

public class Input {
    public static enum InputType{
        PURCHASE_AMOUNT, WINNING_NUMBERS, BONUS_NUMBER;
    }

    public List<Integer> input(InputType inputtype){
        String inputStr = Utils.input();
        List<Integer> inputResult = new ArrayList<>();
        if (inputtype == InputType.PURCHASE_AMOUNT){
            inputResult = purchaseAmountInput(inputStr);
        }
        return inputResult;
    }

    private List<Integer> inputTypeSelect(InputType inputType, String inputStr){
        List<Integer> conversionResult = new ArrayList<>();
        try{
            if (inputType == InputType.PURCHASE_AMOUNT){
                conversionResult = purchaseAmountInput(inputStr);
            }
            /*
            if (inputType == InputType.WINNING_NUMBERS){
                conversionResult = winningNumbersInput(inputStr);
            }
            if (inputType == InputType.BONUS_NUMBER){
                conversionResult = bonusNumberInput(inputStr);
            }
            */
        }catch(IllegalArgumentException e){
            System.out.println("TEST");
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
            throw new IllegalArgumentException(ErrorMessage.NULLSTRING.getMessage());
        }
        for (int i = 0; i < inputStr.length(); i++) {
            if (Utils.isChar(inputStr.charAt(i)) == false) {
                throw new IllegalArgumentException(ErrorMessage.NONNUMERICCHAR.getMessage());
            }
        }
    }

    /*
    public List<Integer> winningNumbersInput(String inputStr){

    }
    public List<Integer> bonusNumberInput(String inputStr){

    }
    */
}
