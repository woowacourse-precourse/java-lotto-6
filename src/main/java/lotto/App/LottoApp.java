package lotto.App;

import lotto.Controller.LottoController;

public class LottoApp {
    private LottoConsole lottoConsole;
    private LottoView lottoView;
    private LottoController lottoController;

    public LottoApp(LottoConsole lottoConsole, LottoView lottoView) {
        this.lottoConsole = lottoConsole;
        this.lottoView = lottoView;
        this.lottoController = new LottoController();
    }

    public void run() {
        //First Step Get Budgets
        lottoView.inputBudgets();
        lottoController.gameStart(lottoConsole.inputBudgets());

        //Buy
        lottoController.buyLottos();

        // Print Purchased History
        lottoView.printPurchasedCnt(String.valueOf(lottoController.getPurchasedLottoCnt()));
        lottoView.printLottos(lottoController.getPurchasedLottos());

        //Get Winning Numbers
        String normalNumbers;
        String bonusNumber;
        lottoView.inputWinningLottoNormalNumber();
        normalNumbers = lottoConsole.inputWinningNormalNumbers();
        lottoView.inputWinningLottoBonusNumber();
        bonusNumber = lottoConsole.inputWinningBonusNumber();
        lottoController.raffleLotto(normalNumbers, bonusNumber);

        lottoView.printWinningResults(lottoController.getWinningResult());
        lottoView.printReturnRate(lottoController.getReturnRate());
    }
}
