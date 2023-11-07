package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {
    private final List<Lotto> lottos;
    private int money;

    public Player() {
        lottos = new ArrayList<>();
        money = 0;
    }

    public void buy(int money) {
        this.money = money;
        while (money >= 1000) {
            money -= 1000;
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningStatistics calculateStatistics(WinningNumbers winningNumbers) {
        Calculator calculator = new Calculator(lottos, winningNumbers);
        Map<Rank, Integer> winningResults = calculator.calculateResults();
        Double winningRate = calculator.calculateWinningRate(winningResults, money);
        return new WinningStatistics(winningResults, winningRate);
    }
}
