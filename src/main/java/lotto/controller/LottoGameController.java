package lotto.controller;

import java.util.List;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.View;

public class LottoGameController {
    private final View view;
    private final InputValidator inputValidator;
    private final LottoMachine lottoMachine;

    public LottoGameController(View view, LottoMachine lottoMachine, InputValidator inputValidator) {
        this.view = view;
        this.lottoMachine = lottoMachine;
        this.inputValidator = inputValidator;
    }

    public void startGame() {
        purchaseLottoTickets();
        WinningLotto winningLotto = setupWinningLotto();
        calculateAndDisplayResults(winningLotto);
    }

    private WinningLotto setupWinningLotto() {
        List<Integer> winningNumbers = getValidWinningNumbers();
        return createValidWinningLotto(winningNumbers);
    }

    private void purchaseLottoTickets() {
        int purchaseAmount = getAndValidateAmount();
        lottoMachine.purchaseLottoTickets(purchaseAmount);
        displayPurchasedLottoTickets();
    }

    private void calculateAndDisplayResults(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult(lottoMachine.getLottoTicketsContainer(), winningLotto);
        view.displayResults(lottoResult);
    }


    public int getAndValidateAmount() {
        while (true) {
            try {
                String purchaseAmount = view.requestPurchaseAmount();
                return inputValidator.validateInputMoney(purchaseAmount);
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto createValidWinningLotto(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = getValidBonusNumber(winningNumbers);
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = view.requestBonusNumber();
                return inputValidator.validateBonusNumber(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                String winningNumbersInput = view.requestWinningNumbers();
                return inputValidator.validateAndParseWinningNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }
    }

    private void displayPurchasedLottoTickets() {
        List<Lotto> purchasedLottoTickets = lottoMachine.getLottoTicketsContainer().getLottoTickets();
        view.printPurchasedLottoAmount(purchasedLottoTickets.size());
        for (Lotto lotto : purchasedLottoTickets) {
            view.printLottoNumbers(lotto);
        }
    }
}

