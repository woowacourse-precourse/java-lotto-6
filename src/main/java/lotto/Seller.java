package lotto;

import static lotto.CommandLine.input;
import static lotto.CommandLine.showln;

public class Seller {

    public int sellTickets() {
        showln("구입금액을 입력해 주세요.");
        int ticketCount = inputTicketCount();
        showln(ticketCount + "개를 구매했습니다.");
        return ticketCount;
    }

    private int inputTicketCount() {
        String purchaseAmount = input("");
        try {
            int amount = Integer.parseInt(purchaseAmount);
            if (amount % 1000 != 0) {
                showln("[ERROR] 1,000원 단위로 입력해 주세요.");
                return inputTicketCount();
            }

            int count = amount / 1000;
            showln("");
            return count;
        } catch (NumberFormatException e) {
            showln("[ERROR] 숫자만 입력해 주세요.");
            return inputTicketCount();
        }
    }
}
