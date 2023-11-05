package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.StringUtil.*;

public class BuyingController {

    AppManager appManager = new AppManager();
    LottoManager lottoManager = new LottoManager();

    public void handle() {

        System.out.println(ENTER_PAY_AMOUNT.getMessage());
        int payAmount = Integer.parseInt(Console.readLine());

        try {
            int lottoTicketsCount = lottoManager.generateLottoTickets(payAmount);
            lottoManager.setLottoTicketCount(lottoTicketsCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            String className = this.getClass().getName();
            appManager.handleInvalidInput(className);
        }
    }
}
