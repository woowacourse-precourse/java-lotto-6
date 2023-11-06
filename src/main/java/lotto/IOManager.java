package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.StringUtil.*;

public class IOManager {

    public void printPayAmountGuide() {
        System.out.println(ENTER_PAY_AMOUNT.getMessage());
    }

    public int readPayAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public void printLottoTicketCount(int lottoTicketCount) {
        System.out.printf(PRINT_LOTTO_COUNT.getMessage(), lottoTicketCount);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }
}
