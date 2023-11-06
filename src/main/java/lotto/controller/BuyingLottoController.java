package lotto.controller;

import java.sql.SQLOutput;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.service.BuyingLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BuyingLottoController {

    private static final int STOP_FLAG = 0;

    private BuyingLottoService buyingLottoService = new BuyingLottoService();

    public void buyLotto(){
        Buyer buyer;

        int money;
        do {
            String inputMoney = InputView.inputMoneyToBuyMessage();
            money = buyingLottoService.validateMoney(inputMoney);
        }while(STOP_FLAG>=money);

        buyer = new Buyer(money);
        buyer.buyLotto();

        OutputView.outputLottoAmountMessage(buyer.getLottoAmount());
        for(int i=0; i< buyer.getLottoAmount(); i++){
            OutputView.outputSortingLottoNumber(buyingLottoService.sortLottoNumber(buyer.getLottos().get(i)));
        }




    }
}
