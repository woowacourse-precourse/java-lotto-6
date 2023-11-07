package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

public class Controller {
    private LottoService lottoService = new LottoService();

    public void getBuyLottoMoney() {
        InputMessage.inputMoney();
        int inputMoney = Integer.parseInt(Console.readLine());
        Customer customer = new Customer(inputMoney);
        lottoService.buyLottoByTicket(customer);
        resultLotto(customer);
    }

    private void resultLotto(Customer customer) {
        for (Lotto lotto : customer.getPurchaseLotteries()) {
            OutputMessage.lottoNumber(lotto.getNumbers());
        }
    }

}
