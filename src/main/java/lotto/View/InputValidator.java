package lotto.View;

import lotto.Controller.ErrorMessage;

public class InputValidator {
    public static void validateInsertInteger(String inputValue){
        if(isBlank(inputValue)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NONE.getMessage());
        }

        if(isNotNumber(inputValue)){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        };

    }

    public static void validateInsertString(String inputValue){
        if(isBlank(inputValue)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NONE.getMessage());
        }
    }

    private static boolean isNotNumber(String inputData){
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean isBlank(String inputData){
        return inputData.isBlank();
    }
}
