package lotto.service;

import static java.util.Objects.isNull;
import static lotto.message.ErrorMessage.HAS_SPACE_ERROR;
import static lotto.message.ErrorMessage.IS_EMPTY_REGISTRY_ERROR;
import static lotto.message.ErrorMessage.NOT_NUMBER_ERROR;

public class InputValidator {
    public boolean isValidNumberList(String inputStr) {
        try {
            if(isEmptyRegistry(inputStr)) {
                throw new IllegalArgumentException(IS_EMPTY_REGISTRY_ERROR.getMessage());
            }
            if(hasSpace(inputStr)) {
                throw new IllegalArgumentException(HAS_SPACE_ERROR.getMessage());
            }
            if(!isNumberList(inputStr)) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean isValidInputNumber(String inputStr) {
        try {
            if(isEmptyRegistry(inputStr)) {
                throw new IllegalArgumentException(IS_EMPTY_REGISTRY_ERROR.getMessage());
            }
            if(hasSpace(inputStr)) {
                throw new IllegalArgumentException(HAS_SPACE_ERROR.getMessage());
            }
            if(!isNumber(inputStr)) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private boolean isNumber(String inputStr) {
        return inputStr != null && inputStr.matches("[0-9]+");
    }

    private boolean isNumberList(String inputStr) {
        return inputStr.replaceAll(",", "").matches("[0-9]+");
    }

    private boolean isEmptyRegistry (String inputStr) {
        return inputStr == null || inputStr.equals("") || inputStr.equals("\n");
    }
    private boolean hasSpace (String inputStr) {
        char[] inputArr = inputStr.toCharArray();
        for (char input: inputArr) {
            if (input == ' ') {
                return true;
            }
        }
        return false;
    }
}
