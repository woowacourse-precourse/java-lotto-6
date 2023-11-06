package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.service.LottoService;
import lotto.view.InputMessage;

public class Controller {
    LottoService lottoService = new LottoService();

    public void getBuyLottoMoney() {
        InputMessage.inputMoney();
        String inputMoney = Console.readLine();
        System.out.println(inputMoney);
        buyLottoMoney(inputMoney);
    }

    public Customer buyLottoMoney(String input) {
        return new Customer(lottoService.stringToIntMoney(input));
    }
}
