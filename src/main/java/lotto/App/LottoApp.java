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
        lottoController.gameStart(
                lottoConsole.inputBudgets()
        );

    }
}
