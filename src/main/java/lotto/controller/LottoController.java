package lotto.controller;

import lotto.common.LottoFinalConsts;
import lotto.domain.LottoMachine;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController implements LottoFinalConsts {

    private LottoView lottoView = new LottoView();
    private LottoService lottoService = new LottoService();
    private LottoException lottoException = new LottoException();

    public void runLotto(){
        final String lottoPurchase = lottoView.inputLottoPurchase();

        notValidPurchase(lottoPurchase);

        final int lottoPurchaseReturn = lottoService.getLottoCount(lottoPurchase);
        lottoView.printLottoPurchase(lottoPurchaseReturn);

        LottoMachine lottoMachine = lottoService.createLottoMachine(lottoPurchase, lottoPurchaseReturn);
        lottoView.printPublishedLotto(lottoMachine.getLottos());

        final String winningNumber = lottoView.inputLottoWinningNumber();
        final String bonusNumber = lottoView.inputLottoBonusNumber();

        runLottoMachine(lottoMachine, winningNumber, bonusNumber);

        lottoView.printTotalResults(lottoMachine.getLottoRanks(), lottoMachine.getLottoReturnRate());
    }

    public void notValidPurchase(String lottoPurchase){
        if (!lottoException.isInputOnlyNumber(lottoPurchase)){
            runLotto();
        }
    }

    public void runLottoMachine(LottoMachine lottoMachine, String winningNumber, String bonusNumber){
        lottoService.saveWinningAndBonusNumbers(lottoMachine, winningNumber, bonusNumber);
        lottoService.saveRankCount(lottoMachine);
        lottoService.computeLottoReturnRate(lottoMachine);
    }
}
