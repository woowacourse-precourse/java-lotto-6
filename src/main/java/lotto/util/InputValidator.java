package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public boolean isValidInputMoney(String userInput) {
        try {
            int inputMoney = Integer.parseInt(userInput);
            if (inputMoney % 1000 != 0) {
                throw new IllegalArgumentException(Message.INPUT_INSERT_MONEY_THOUSAND_ERROR_MESSAGE);
            }
        } catch(NumberFormatException e) {
            System.out.println(Message.INPUT_NOT_NUMBER_MESSAGE);
            return false;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isValidInteger(String[] splitUserInput) {
        for (String sNum : splitUserInput) {
            try {
                Integer.parseInt(sNum);
            } catch (NumberFormatException e) {
                System.out.println(Message.INPUT_LOTTO_NUM_ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public void isNotDuplicated(String[] splitUserInput) {
        List<Integer> inputDangchum = new ArrayList<>();
        for (String sNum : splitUserInput) {
            int iNum = Integer.parseInt(sNum);
            if (inputDangchum.contains(iNum)) {
                throw new IllegalArgumentException(Message.DUPLICATE_MESSAGE);
            }
            inputDangchum.add(iNum);
        }
    }
}
