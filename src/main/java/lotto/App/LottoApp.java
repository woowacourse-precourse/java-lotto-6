package lotto.App;

import lotto.Controller.LottoController;

public class LottoApp {
    private final LottoConsole lottoConsole;
    private final LottoView lottoView;
    private final LottoController lottoController;

    public LottoApp(LottoConsole lottoConsole, LottoView lottoView) {
        this.lottoConsole = lottoConsole;
        this.lottoView = lottoView;
        this.lottoController = new LottoController();
    }

    public void inputBudgets() {
        do {
            lottoView.inputBudgets();
        } while (lottoController.gameStart(lottoConsole.inputBudgets()));
    }

    public void run() {
        //First Step Get Budgets
        inputBudgets();

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
