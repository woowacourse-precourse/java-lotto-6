package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ErrorMessage;
import lotto.view.PrintMessage;

public class InputLottoAmount {
    public static int setInputLottoAmount() {
        PrintMessage.printStart();
        int amount = setAmount();
        int lottoTicketCount = setLottoTicketCount(amount);
        return lottoTicketCount;

    }

    private static int setLottoTicketCount(int amount) {
        return amount / 1000;
    }

    public static int setAmount() {
        int amount = 0;
        try {
            String input = Console.readLine();
            isNumeric(input);
        } catch (IllegalArgumentException e) {
            ErrorMessage.printErrorMessage(e);
            return setInputLottoAmount();
        }
        return amount;
    }

    public static void isNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUM_ERROR);
        }

    }
}
