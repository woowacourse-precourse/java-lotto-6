package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;
import java.util.Map;

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
    public void run() {
        // 구매 금액 입력
        int purchaseCount = loopByPurchaseAmountException();
        // 유저 로또 생성
        List<LottoPurchase> userLotteries = lottoPurchaseService.issueLotteryByPurchaseAmount(purchaseCount);
        outputView.userLotteries(userLotteries,purchaseCount);
        // 당첨 번호 생성
        Lotto lotto = loopByWinningNumberException();
        // 보너스 번호 생성
        BonusNumber bonusNumber = loopByBonusNumberException(lotto);
        // 통계 출력
        outputView.winningStatistics();
        Map<Integer,Integer> resultCount = resultService.containsNumber(lotto.getNumbers(),userLotteries, bonusNumber.getBonusNumber());
        outputView.winningResult(resultCount);
        long winningMoney = resultService.calculateWinningMoney(resultCount);
        double statistics = resultService.statistics(winningMoney,purchaseCount);
        outputView.statistics(statistics);
    }
}
