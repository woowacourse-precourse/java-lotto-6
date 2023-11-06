package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.consts.ErrorMessage;
import lotto.consts.MachineMessage;

public class PurchaseView {
    private static final int PRICE = 1000;
    private static final String R_NUMBER = "^[0-9]*$";
    public static int lotto() {
        String input;
        System.out.println();
        do {
            System.out.println(MachineMessage.MACHINE_MESSAGE_BUY.getMessage());
            input = Console.readLine().trim();
        } while (!isErrorOccurred(input));

        return Integer.parseInt(input);
    }

    public static boolean isErrorOccurred(String input) {
        try {
            validateAmount(input);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            System.out.println();
            return false;
        }
        return true;
    }

    public static void validateAmount(String input) throws IllegalArgumentException {
        if(!input.matches(R_NUMBER)){
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_INPUT_MUST_BE_NUMBER.getMessage());
        }

        if(Integer.parseInt(input) % PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_AMOUNT_UNIT.getMessage());
        }
    }
}
