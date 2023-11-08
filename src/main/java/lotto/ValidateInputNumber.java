package lotto;

import java.util.ArrayList;
import java.util.List;

public class ValidateInputNumber {
    public int inputNumber(String number) {
        int numberValue;
        try {
            numberValue = Integer.parseInt(number);
            return numberValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE + "유효한 숫자가 아닙니다.");
        }
    }

    public List<Integer> validateWinNumber(String prizeNumber) {
        List<Integer> winNumber = new ArrayList<>();
        try {
            for (String s : prizeNumber.split(",")) {
                int EachNumber = inputNumber(s);
                winNumber.add(EachNumber);
            }
            return winNumber;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
