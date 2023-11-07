package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.LottoManager;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;
    private final LottoList lottoList;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoManager = new LottoManager();
        this.lottoList = new LottoList();
        this.lottoService = new LottoService();
    }

    public void startLottoGame() {
        int purchaseAmount = getPurchaseAmount();
        showLottoTicketNumbers(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbersFromUser();
        getBonusNumberFromUser();
    }

    private void getBonusNumberFromUser() {
        outputView.askBonusNumber();
    }

    private List<Integer> getWinningNumbersFromUser() {
        outputView.askWinningNumbers();
        List<Integer> winningNumbers = inputView.getWinningNumbersFromUser();
        return winningNumbers;
    }

    private void showLottoTicketNumbers(int purchaseAmount) {
        int numberOfLottoTicketsToBuy = lottoService.calculateNumberOfLottoTicketsToBuy(purchaseAmount);
        List<Lotto> lottoList = lottoService.buyLottoTickets(purchaseAmount);
        showLottoTickets(numberOfLottoTicketsToBuy, lottoList);
    }

    private void showLottoTickets(int numberOfLottoTicketsToBuy, List<Lotto> lottoList) {
        outputView.showPurchasedLottoTicketsNumber(numberOfLottoTicketsToBuy);
        outputView.showPurchasedLottoTickets(lottoList);
    }

    private int getPurchaseAmount() {
        outputView.askPurchaseAmount();
        int purchaseAmount = inputView.getPurchaseAmountFromUser();
        lottoService.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }


}
