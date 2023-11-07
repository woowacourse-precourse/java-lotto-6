package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoService lottoService;
    private final ResultService resultService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(){
        this.lottoPurchaseService = new LottoPurchaseService();
        this.lottoService = new LottoService();
        this.resultService = new ResultService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
    private int loopByPurchaseAmountException() {
        try {
            int lottoPurchaseAmount = LottoPurchase.purchaseLottery(inputView.lottoPurchaseAmount());
            outputView.newLine();
            return lottoPurchaseAmount;
        }catch(IllegalArgumentException e){
            outputView.errorMessagePrint(e.getMessage());
            return loopByPurchaseAmountException();
        }
    }
    private Lotto loopByWinningNumberException(){
        try {
            Lotto lotto = lottoService.createWinningNumber(inputView.winnerNumbers());
            outputView.newLine();
            return lotto;
        }catch(IllegalArgumentException e){
            outputView.errorMessagePrint(e.getMessage());
            return loopByWinningNumberException();
        }
    }
    private BonusNumber loopByBonusNumberException(Lotto lotto) {
        try {
            BonusNumber bonusNumber = BonusNumber.bonusNumberOf(lotto.getNumbers(),inputView.bonusNumber());
            outputView.newLine();
            return bonusNumber;
        }catch(IllegalArgumentException e){
            outputView.errorMessagePrint(e.getMessage());
            return loopByBonusNumberException(lotto);
        }
    }
}
