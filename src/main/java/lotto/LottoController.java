package lotto;

import lotto.domain.BuyLottoInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void doGame(){
        BuyLottoInfo buyLottoInfo = buyTickets();
        outputView.printUserLottoInfo(buyLottoInfo);


    }

    private BuyLottoInfo buyTickets() {
        int amount = inputView.inputPurchaseAmount();
        return lottoService.createLottoTickets(amount);
    }



}
