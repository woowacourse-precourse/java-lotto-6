package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoResult;
import lotto.service.LottoService;
import lotto.service.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final InputValidator inputValidator;

    private int purchaseAmount;
    private LottoManager lottoManager;
    private List<Lotto> lottoList;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.lottoService = new LottoService();
    }

    public void startLottoGame() {
        buyLotto();
        setLottoNumbers();
        getLottoResult();
    }

    private void buyLotto() {
        this.purchaseAmount = getPurchaseAmount();
        showLottoTicketNumbers(this.purchaseAmount);
    }

    private void setLottoNumbers() {
        LottoManager winningNumbers = getWinningNumbersFromUser();
        addBonusNumberToLottoManager(winningNumbers);
        this.lottoManager = winningNumbers;
    }

    private void getLottoResult() {
        LottoResult lottoResult = lottoService.calculateLottoResult(lottoManager, lottoList);
        outputView.showLottoResult(lottoResult.getResultMap());
        Double profitRate = lottoService.computeProfitRate(purchaseAmount, lottoResult.getProfit());
        outputView.showProfitRate(profitRate);
    }

    private int getPurchaseAmount() {
        outputView.askPurchaseAmount();
        return inputValidator.validatePurchaseAmount(inputView);
    }

    private void showLottoTicketNumbers(int purchaseAmount) {
        int numberOfLottoTicketsToBuy = lottoService.calculateNumberOfLottoTicketsToBuy(purchaseAmount);
        List<Lotto> lottoList = lottoService.buyLottoTickets(purchaseAmount);
        this.lottoList = lottoList;
        showLottoTickets(numberOfLottoTicketsToBuy, lottoList);
    }

    private void showLottoTickets(int numberOfLottoTicketsToBuy, List<Lotto> lottoList) {
        outputView.showPurchasedLottoTicketsNumber(numberOfLottoTicketsToBuy);
        outputView.showPurchasedLottoTickets(lottoList);
    }

    private LottoManager getWinningNumbersFromUser() {
        outputView.askWinningNumbers();
        return inputValidator.validateWinningNumbers(inputView);
    }

    private void addBonusNumberToLottoManager(LottoManager winningNumbers) {
        outputView.askBonusNumber();
        inputValidator.validateBonusNumber(winningNumbers, inputView);
    }
}
