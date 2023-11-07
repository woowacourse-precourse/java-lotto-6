package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import lotto.service.LottoService;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;
import java.util.List;

public class Controller {
    private LottoService lottoService = new LottoService();
    private WinningNumber winningNumber;

    public void start(){
        getBuyLottoMoney();
        winningNumberShow();
    }

    private void getBuyLottoMoney() {
        InputMessage.inputMoney();
        int inputMoney = Integer.parseInt(Console.readLine());
        Customer customer = new Customer(inputMoney);
        lottoService.buyLottoByTicket(customer);
        resultLotto(customer);
    }

    private void resultLotto(Customer customer) {
        OutputMessage.purchaseMessage(customer.getPurchaseMoney() / 1000);
        for (Lotto lotto : customer.getPurchaseLotteries()) {
            OutputMessage.lottoNumber(lotto.getNumbers());
        }
    }

    private void winningNumberShow() {
        winningNumber = new WinningNumber(getWinningNumber(),getBonusNumber());
    }

    private List<Integer> getWinningNumber() { // String[] vs List<Integer> ..
        InputMessage.winningNumberInput();
        String input = Console.readLine().trim();
        return lottoService.integerList(input);
    }

    private int getBonusNumber() {
        InputMessage.bonusNumberInput();
        int input = Integer.parseInt(Console.readLine().trim());
        return input;
    }

}
