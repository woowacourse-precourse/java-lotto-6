package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class InputLottoAmount {
    public static int setInputLottoAmount() {
        int amount = 0;
        String input = Console.readLine();
        amount = Integer.parseInt(input);
        int lottoTicketCount = setLottoTicketCount(amount);
        return lottoTicketCount;
    }

    private static int setLottoTicketCount(int amount) {
        return amount / 1000;
    }
}
