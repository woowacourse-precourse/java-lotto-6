package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoStatistics;
import lotto.model.Purchase;
import lotto.util.NumbersValidator;
import lotto.view.LottoView;

import static lotto.model.LottoStatistics.DEFAULT_VALUE;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final LottoStatistics lottoStatistics;
    private final Purchase purchase;

    public LottoController(LottoMachine lottoMachine, LottoStatistics lottoStatistics, Purchase purchase) {
        this.lottoMachine = lottoMachine;
        this.lottoStatistics = lottoStatistics;
        this.purchase = purchase;
    }

    public void run() {
        int purchaseAmount = readAndValidatePurchaseAmount();

        ArrayList<Lotto> lottoTickets = generateLottoTickets(purchaseAmount);

        readAndValidateWinningNumber();
        readAndValidateBonusNumber();

        lottoStatistics.writeStatistics(lottoMachine.determineLottoWinning(lottoTickets));

        LottoView.printLottoStatistics(lottoStatistics.getStatistics());
        LottoView.printLottoProfit(lottoStatistics.calculateLottoProfit(purchase.getPurchaseAmount()));
    }

    private int readAndValidatePurchaseAmount() {
        int purchaseAmount = DEFAULT_VALUE;
        boolean validPurchase = false;
        while (!validPurchase) {
            try {
                String purchaseAmountInput = LottoView.readPurchaseAmount();
                NumbersValidator.validateNumber(purchaseAmountInput);
                purchaseAmount = Integer.parseInt(purchaseAmountInput);
                validPurchase = true;
            } catch (IllegalArgumentException e) {
                LottoView.displayErrorMessage(e);
            }
        }
        return purchaseAmount;
    }

    private ArrayList<Lotto> generateLottoTickets(int purchaseAmount) {
        purchase.setPurchase(purchaseAmount);
        int purchaseNumber = purchase.getPurchaseNumber();
        ArrayList<Lotto> lottoTickets = lottoMachine.runLottoMachine(purchaseNumber);
        LottoView.printLottoTickets(purchaseNumber, lottoTickets);
        return lottoTickets;
    }

    private void readAndValidateWinningNumber() {
        boolean vaildWinningNumber = false;
        while (!vaildWinningNumber) {
            try {
                String winningNumberInput = LottoView.readWinningNumber();
                NumbersValidator.validateLottoNumber(winningNumberInput);
                List<String> winningNumber = Arrays.asList(winningNumberInput.split(","));
                List<Integer> processedWinningNumber = winningNumber.stream()
                        .map(Integer::parseInt).collect(Collectors.toList());
                lottoMachine.setWinningNumbers(processedWinningNumber);
                vaildWinningNumber = true;
            } catch (IllegalArgumentException e) {
                LottoView.displayErrorMessage(e);
            }
        }
    }

    private void readAndValidateBonusNumber() {
        boolean vaildBonusNumber = false;
        while (!vaildBonusNumber) {
            try {
                String bonusNumberInput = LottoView.readBonusNumber();
                NumbersValidator.validateNumber(bonusNumberInput);
                int bonusNumber = Integer.parseInt(bonusNumberInput);
                lottoMachine.setBonusNumber(bonusNumber);
                vaildBonusNumber = true;
            } catch (IllegalArgumentException e) {
                LottoView.displayErrorMessage(e);
            }
        }
    }
}
