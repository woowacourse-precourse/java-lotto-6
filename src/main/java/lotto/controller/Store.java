package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.InputStatus;
import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;
import lotto.domain.PurchaseQuantity;
import lotto.domain.PrizeType;
import lotto.domain.WinningStatistics;
import lotto.exception.ExceptionStatus;
import lotto.view.Printer;
import lotto.view.UserInput;

public class Store {
    private static long amount;

    private static List<Lotto> lottos;
    private static Lotto winningNumbers;
    private static BonusNumber bonusNumber;
    private static InputStatus status = InputStatus.INPUT_AMOUNT;

    public void start() {
        while (!status.equals(InputStatus.INPUT_END)) {
            switch (status) {
                case INPUT_AMOUNT -> purchaseLotto();
                case INPUT_WINNING -> setWinningNumber();
                case INPUT_BONUS -> setBonusNumbers(winningNumbers);
            }
        }
        displayStatics();
    }

    private void purchaseLotto() {
        try {
            PurchaseQuantity purchaseQuantity = new PurchaseQuantity(UserInput.inputAmount());

            amount = purchaseQuantity.getAmount();
            long lottoQuantity = purchaseQuantity.getLottoPurchases();

            IssuedLottos issuedLottos = new IssuedLottos(lottoQuantity);
            lottos = issuedLottos.getIssuedLottos();

            printPurchasedLottos(lottos, lottoQuantity);

            status = InputStatus.INPUT_WINNING;
        } catch (NumberFormatException e) {
            System.out.println(ExceptionStatus.INPUT_COMMON_NOT_A_NUMBER);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void setWinningNumber() {
        try {
            Lotto lotto = new Lotto(UserInput.inputWinningNumber());
            winningNumbers = lotto;
            status = InputStatus.INPUT_BONUS;
        } catch (IllegalArgumentException e) {
            status = InputStatus.INPUT_WINNING;
        }
    }

    private void setBonusNumbers(Lotto winningNumbers) {
        try {
            BonusNumber inputBonusNumber = new BonusNumber(UserInput.inputbonusNumber(), winningNumbers);
            status = InputStatus.INPUT_END;
            bonusNumber = inputBonusNumber;
        } catch (IllegalArgumentException e) {
            status = InputStatus.INPUT_BONUS;
        }
    }

    private void printPurchasedLottos(List<Lotto> lottos, long lottoQuantity) {
        Printer.printPurchasedLottoQuantity(lottoQuantity);
        Printer.printLottoNumbers(lottos);
    }

    private void displayStatics() {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.calculateNumberOfWins(lottos, winningNumbers, bonusNumber.getBonusNumber());

        HashMap<PrizeType, Integer> winningHistories = winningStatistics.getLottoRecords();
        String rewardRate = winningStatistics.calculateRewardRate(amount);

        Printer.printStatics(winningHistories);
        Printer.printRewardRate(rewardRate);
    }


}
