package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoManager;
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

    private void getLottoResult() {

    }

    private void buyLotto() {
        int purchaseAmount = getPurchaseAmount();
        showLottoTicketNumbers(purchaseAmount);
    }

    private void setLottoNumbers() {
        LottoManager winningNumbers = getWinningNumbersFromUser();
        addBonusNumberToWinningNumbers(winningNumbers);
        this.lottoManager = winningNumbers;
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

    private void addBonusNumberToWinningNumbers(LottoManager winningNumbers) {
        outputView.askBonusNumber();
        inputValidator.validateBonusNumber(winningNumbers, inputView);
    }
}
