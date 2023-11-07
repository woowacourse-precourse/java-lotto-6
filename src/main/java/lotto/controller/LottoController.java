package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Receipt;
import lotto.model.PurchaseAmount;
import lotto.model.UserLottos;
import lotto.model.WinningNumbers;

import lotto.service.AutoLottoService;
import lotto.service.LottoScoringService;

import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {
    InputView inputView;
    OutputView outputView;
    AutoLottoService autoLottoService;
    LottoScoringService lottoScoringService;

    private static class SingletonLottoController {
        private static final LottoController LOTTO_CONTROLLER = new LottoController();
    }

    public static LottoController getInstance() {
        return SingletonLottoController.LOTTO_CONTROLLER;
    }

    private LottoController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        autoLottoService = AutoLottoService.getInstance();
        lottoScoringService = LottoScoringService.getInstance();
    }

    public void run() {
        UserLottos userLottos = purchaseLotto();

        showResult(userLottos);
    }

    private UserLottos purchaseLotto() {
        UserLottos userLottos;
        PurchaseAmount purchaseAmount = inputPurchaseAmount();

        Integer numberOfLotto = purchaseAmount.getNumberOfTicket();

        userLottos = generateUserLotto(numberOfLotto);
        return userLottos;
    }

    private void showResult(UserLottos userLottos) {
        WinningNumbers winningNumbers = inputWinningNumber();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        Receipt receipt = writeReceipt(winningNumbers, bonusNumber, userLottos);

        printReceipt(receipt);
    }

    private PurchaseAmount inputPurchaseAmount() {
        PurchaseAmount purchaseAmount;
        try {
            outputView.printInputPurchaseAmountMessage();

            Long paidMoney = inputView.inputPurchaseAmount();

            purchaseAmount = new PurchaseAmount(paidMoney);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);

            purchaseAmount = inputPurchaseAmount();
        }
        return purchaseAmount;
    }

    private UserLottos generateUserLotto(Integer numberOfLotto) {
        UserLottos userLottos;
        List<Lotto> userLottoList = new ArrayList<>();

        outputView.printNumberOfPurchaseMessage(numberOfLotto);

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumbers = autoLottoService.generateLottoNumbers();
            outputView.printLottoNumbers(lottoNumbers);

            Lotto newLotto = new Lotto(lottoNumbers);
            userLottoList.add(newLotto);
        }
        userLottos = new UserLottos(userLottoList);
        return userLottos;
    }

    private WinningNumbers inputWinningNumber() {
        WinningNumbers winningNumbers;
        try {
            outputView.printInputWinningNumMessage();

            List<Integer> winningNumbersInput = inputView.inputWinningNumbers();

            winningNumbers = new WinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);

            winningNumbers = inputWinningNumber();
        }
        return winningNumbers;
    }

    private BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        BonusNumber bonusNumber;
        try {
            outputView.printInputBonusNumMessage();

            Integer bonusNumberInput = inputView.inputBonusNumber();

            bonusNumber = new BonusNumber(winningNumbers, bonusNumberInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);

            bonusNumber = inputBonusNumber(winningNumbers);
        }

        return bonusNumber;
    }

    private Receipt writeReceipt(WinningNumbers winningLotto, BonusNumber bonusNumber, UserLottos userLottos) {
        Receipt receipt;

        Integer[] userLottoRankings = lottoScoringService.rankUserLottos(winningLotto, bonusNumber, userLottos);

        receipt = new Receipt(userLottoRankings, userLottos.getNumberOfLotto());

        return receipt;
    }

    private void printReceipt(Receipt receipt) {
        outputView.printReceiptTitle();

        outputView.printReceiptDetail(receipt);

        outputView.printProfitRatio(receipt.getProfitRatio());
    }
}
