package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.LottoManager;
import lotto.service.LottoService;
import lotto.service.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoList lottoList;
    private final LottoService lottoService;
    private final InputValidator inputValidator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoList = new LottoList();
        this.inputValidator = new InputValidator();
        this.lottoService = new LottoService();
    }

    public void startLottoGame() {
        int purchaseAmount = getPurchaseAmount();
        showLottoTicketNumbers(purchaseAmount);
        LottoManager winningNumbers = getWinningNumbersFromUser();
        getBonusNumber(winningNumbers);

    }

    private int getPurchaseAmount() {
        outputView.askPurchaseAmount();
        int purchaseAmount = inputValidator.getPurchaseAmount(inputView);
        return purchaseAmount;
    }

    private void addBonusNumberToWinningNumbers(LottoManager winningNumbers, int bonusNumber) {
        winningNumbers.addBonusNumber(bonusNumber);
    }

    private int getBonusNumberFromUser() {
        outputView.askBonusNumber();
        return inputView.getBonusNumberFromUser();
    }

    private void getBonusNumber(LottoManager winningNumbers) {
        while (true) {
            try {
                int bonusNumber = getBonusNumberFromUser();
                addBonusNumberToWinningNumbers(winningNumbers, bonusNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 정수로 변환이 불가능합니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage() + " 다시 입력해주세요.");
            }
        }
    }

    private LottoManager getWinningNumbersFromUser() {
        outputView.askWinningNumbers();
        return inputValidator.validateWinningNumbers(inputView);
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


}
