package controller;

import java.util.List;
import model.FinanceManager;
import model.GameManager;
import model.dto.LottoResponse;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private FinanceManager financeManager;
    private GameManager gameManager;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        initGame();
        informLottos();
    }

    private void informLottos() {
        outputView.informLottoCount(financeManager.calculateLottoCount());
        List<LottoResponse> lottoResponses = gameManager.getGeneratedLottos();
        outputView.noticeGeneratedLottos(lottoResponses);
    }

    private void initGame() {
        initFinanceManager();
        initGameManager();
    }

    private void initFinanceManager() {
        outputView.askPurchaseAmount();
        String inputPurchase = inputView.read();
        while (!FinanceManager.isValidArgument(inputPurchase)) {
            inputPurchase = inputView.read();
        }

        financeManager = FinanceManager.createDefault(inputPurchase);
    }

    private void initGameManager() {
        int lottoCount = financeManager.calculateLottoCount();
        gameManager = GameManager.createDefault(lottoCount);
    }
}
