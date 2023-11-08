package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.dto.BuyLottoInfo;
import lotto.domain.dto.LottoWinResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
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

        List<Integer> winningNumbers = inputView.inputWinningNumber();
        BonusNumber bonusNumber = inputView.inputBonusNumber();
        lottoService.createWinningLotto(winningNumbers, bonusNumber);

        LottoWinResult lottoWinResult = lottoService.checkWinningLotto();
        outputView.printLottoResult(lottoWinResult);
    }

    private BuyLottoInfo buyTickets() {
        int amount = inputView.inputPurchaseAmount();
        return lottoService.createLottoTickets(amount);
    }

}
