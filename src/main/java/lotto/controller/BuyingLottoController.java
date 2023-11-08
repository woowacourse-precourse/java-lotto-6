package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LotteryGenerator;
import lotto.service.BuyingLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BuyingLottoController {

    private Buyer buyer;
    private final LotteryGenerator lotteryGenerator = new LotteryGenerator();
    private final int STOP_FLAG = -1;
    private BuyingLottoService buyingLottoService = new BuyingLottoService();

    public Buyer buyLotto(){
        int money;
        do {
            String inputMoney = InputView.inputMoneyToBuyMessage();
            money = buyingLottoService.validateInputMoney(inputMoney);
        }while(money==STOP_FLAG);

        buyer = new Buyer(money);
        buyer.buyLotto(lotteryGenerator);

        OutputView.outputLottoAmountMessage(buyer.getLottoAmount());
        for(int i=0; i< buyer.getLottoAmount(); i++){
            OutputView.outputSortingLottoNumber(buyingLottoService.sortLottoNumber(buyer.getLottos().get(i)));
        }

        return buyer;
    }
}
