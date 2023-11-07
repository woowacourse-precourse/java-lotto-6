package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.consts.Constants;
import lotto.consts.ErrorMessage;
import lotto.consts.MachineMessage;

public class PurchaseView {
    public static int lotto() {
        String input;
        do {
            System.out.println(MachineMessage.MACHINE_MESSAGE_BUY.getMessage());
            input = Console.readLine().trim();
        } while (!isErrorOccurred(input));

        return Integer.parseInt(input);
    }

    public static boolean isErrorOccurred(String input) {
        try {
            validateAmountIsNumber(input);
            validateAmountUnit(input);
            validateAmountIsZero(input);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            System.out.println();
            return false;
        }
        return true;
    }

    public static void validateAmountIsNumber(String input) throws IllegalArgumentException {
        if(!input.matches(Constants.R_NUMBER)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INPUT_MUST_BE_NUMBER.getMessage());
        }
    }

    public static void validateAmountUnit(String input) throws IllegalArgumentException {
        if(Integer.parseInt(input) % Constants.PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_AMOUNT_UNIT.getMessage());
        }
    }

    public static void validateAmountIsZero(String input) throws IllegalArgumentException {
        if(input.matches(Constants.ZERO)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_BUY_MORE_THAN_ONE.getMessage());
        }
    }
}
