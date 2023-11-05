package lotto.controller;

import lotto.domain.Recipient;
import lotto.service.BuyingLottoService;
import lotto.view.InputView;

public class BuyingLottoController {

    private BuyingLottoService buyingLottoService = new BuyingLottoService();
    public void buyLotto(){
        Recipient recipient = new Recipient();

        int money;
        do {
            String inputMoney = InputView.inputMoneyToBuyMessage();
            money = buyingLottoService.validateMoney(inputMoney);
        }while(0>=money);

        System.out.println("end");
    }
}
