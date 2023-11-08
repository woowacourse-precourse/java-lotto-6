package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.model.Lotto;

public class LottoUI {

    public int purchase() {
        boolean isValidInput = false;
        int amount = 0;

        while (!isValidInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String userInput = Console.readLine();
                amount = Integer.parseInt(userInput);
                isAmountValid(amount);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NOT_VALID_AMOUNT.getMessage());
            }
        }

        return amount;
    }

    private void isAmountValid(int amount) {
        int count = amount / 1_000;
        if (count == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void printLottoPurchase(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
