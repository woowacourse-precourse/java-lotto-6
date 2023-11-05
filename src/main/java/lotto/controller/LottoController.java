package lotto.controller;

import java.util.List;
import java.util.Scanner;
import lotto.LottoBuying;
import lotto.View.ConsoleInput;
import lotto.View.ConsoleOutput;
import lotto.WinningCalculator;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

public class LottoController {
    public static void start() {
        Scanner scanner = new Scanner(System.in);

        int purchaseAmount = ConsoleInput.getPurchaseAmount(scanner);
        List<Lotto> purchasedLottos = LottoBuying.buyLotto(purchaseAmount);

        ConsoleOutput.printPurchasedLottos(purchasedLottos);

        WinningNumbers winningNumbers = getWinningNumbers(scanner);

        WinningCalculator.calculateAndPrintRanks(purchasedLottos, winningNumbers);
    }

    private static WinningNumbers getWinningNumbers(Scanner scanner) {
        List<Integer> winningNumbers = ConsoleInput.getWinningNumbers(scanner);
        int bonusNumber = ConsoleInput.getBonusNumber(scanner);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
