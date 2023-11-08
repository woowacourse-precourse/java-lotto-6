package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.IssuedLottos;
import lotto.domain.Lotto;
import lotto.domain.PurchaseQuantity;
import lotto.exception.ExceptionStatus;
import lotto.view.Printer;
import lotto.view.UserInput;

public class Store {
    private static long amount;

    private static List<Lotto> lottos;
    private static Lotto winningNumbers;
    private static BonusNumber bonusNumber;

    public void start() {
        try {
            purchaseLotto();
            lotteryDraws();
            //display winning statics
        } catch (NumberFormatException exception) {
            System.out.println(ExceptionStatus.INPUT_COMMON_NOT_A_NUMBER);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }

    private void purchaseLotto() {
        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(UserInput.inputAmount());
        amount = purchaseQuantity.getAmount();
        long lottoQuantity = purchaseQuantity.getLottoPurchases();

        IssuedLottos issuedLottos = new IssuedLottos(lottoQuantity);
        lottos = issuedLottos.getIssuedLottos();
        printPurchasedLottos(lottos, lottoQuantity);
    }

    private void lotteryDraws() {
        winningNumbers = setWinningNumber();
        bonusNumber = setBonusNumbers(winningNumbers);
    }

    private Lotto setWinningNumber() {
        return new Lotto(UserInput.inputWinningNumber());
    }

    private BonusNumber setBonusNumbers(Lotto winningNumbers) {
        return new BonusNumber(UserInput.inputbonusNumber(), winningNumbers);
    }

    private void printPurchasedLottos(List<Lotto> lottos, long lottoQuantity) {
        Printer.printPurchasedLottoQuantity(lottoQuantity);
        Printer.printLottoNumbers(lottos);
    }

}
