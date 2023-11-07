package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.ErrorMessage;
import lotto.view.PrintMessage;

public class InputLottoAmount {
    public static int setInputLottoAmount() {
        PrintMessage.printStart();
        int amount = setAmount();
        int lottoTicketCount = setLottoTicketCount(amount);
        PrintMessage.printTicketCount(lottoTicketCount);
        return lottoTicketCount;
    }

    public static int setAmount() {
        try {
            String input = Console.readLine();
            isNumeric(input);
            int amount = Integer.parseInt(input);
            checkZero(amount);
            checkTicket(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            ErrorMessage.printErrorMessage(e);
            PrintMessage.printStart();
            return setAmount();
        }
    }

    public static void isNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUM_ERROR);
        }

    }


    static void checkZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ZERRO);
        }
    }

    static void checkTicket(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_TICKET_COUNT);
        }
    }

    private static int setLottoTicketCount(int amount) {
        return amount / 1000;
    }

}
