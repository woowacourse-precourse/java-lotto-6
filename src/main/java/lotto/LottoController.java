package lotto;

import lotto.domain.Customer;
import lotto.domain.LottoSeller;
import lotto.util.InputUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    Customer customer = new Customer();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void purchaseLotto() {
        try {
            inputView.requestMoneyMessage();
            customer.scanPocket(InputUtil.getUserInput());
            LottoSeller seller = new LottoSeller();
            seller.checkRemainder(customer.getMoney());
            outputView.printLottoCount(seller.getSellCount());
            customer.setLotteryTicket(seller.makeLottoTickets());
            outputView.printLottoNumbers(customer.getLotteryTicket());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLotto();
        }
    }
}
