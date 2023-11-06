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

        LottoBuying lottoBuying = new LottoBuying();
        List<Lotto> lottos = lottoBuying.buyLottos(purchaseAmount);

        ConsoleOutput output = new ConsoleOutput();
        output.displayPurchasedLottos(lottos);

        WinningNumbers winningNumbers = input.getWinningNumbers();
        WinningCalculator winningCalculator = new WinningCalculator();
        List<Lotto> winningLottos = generateWinningLottos();
        winningCalculator.calculateWinnings(lottos, winningLottos);

        output.displayWinningStatistics(winningCalculator.getWinningStatistics());

        double totalProfitRate = winningCalculator.calculateTotalProfitRate(purchaseAmount);
        output.displayTotalProfitRate(totalProfitRate);
    }


    private List<Lotto> generateWinningLottos() {
        List<Lotto> winningLottos = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            winningLottos.add(new Lotto(LottoGenerator.generateRandomNumbers()));
        }
        return winningLottos;
    }
}
