package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoBuying;
import lotto.LottoGenerator;
import lotto.WinningCalculator;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoController {
    public void run() {
        ConsoleInput input = new ConsoleInput();
        int purchaseAmount = input.getPurchaseAmount();
        WinningNumbers winningNumbers = input.getWinningNumbers();

        LottoBuying lottoBuying = new LottoBuying();
        List<Lotto> lottos = lottoBuying.buyLottos(purchaseAmount);

        WinningCalculator winningCalculator = new WinningCalculator();
        List<Lotto> winningLottos = generateWinningLottos();

        winningCalculator.calculateWinnings(lottos, winningLottos);

        ConsoleOutput output = new ConsoleOutput();
        output.displayPurchasedLottos(lottos);
        output.displayWinningStatistics(winningCalculator.getWinningStatistics());
        output.displayTotalProfitRate(winningCalculator.calculateTotalProfitRate(purchaseAmount));
    }

    private List<Lotto> generateWinningLottos() {
        List<Lotto> winningLottos = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            winningLottos.add(new Lotto(LottoGenerator.generateRandomNumbers()));
        }
        return winningLottos;
    }
}
