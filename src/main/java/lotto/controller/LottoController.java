package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private LottoView lottoView = new LottoView();
    private LottoService lottoService = new LottoService();

    public void runLotto(){
        final String lottoPurchase = lottoView.inputLottoPurchase();
        final int lottoPurchaseReturn = lottoService.getLottoCount(lottoPurchase);

        lottoView.printLottoPurchase(lottoPurchaseReturn);

        LottoMachine lottoMachine = lottoService.createLottoMachine(lottoPurchase, lottoPurchaseReturn);
        lottoView.printPublishedLotto(lottoMachine.getLottos());

        String winningNumber = lottoView.inputLottoWinningNumber();
        String bonusNumber = lottoView.inputLottoBonusNumber();

        runLottoMachine(lottoMachine, winningNumber, bonusNumber);

        lottoView.printTotalResults(lottoMachine.getLottoRanks(), lottoMachine.getLottoReturnRate());
    }

    public void runLottoMachine(LottoMachine lottoMachine, String winningNumber, String bonusNumber){
        lottoService.saveWinningAndBonusNumbers(lottoMachine, winningNumber, bonusNumber);
        lottoService.saveRankCount(lottoMachine);
        lottoService.computeLottoReturnRate(lottoMachine);
    }
}
