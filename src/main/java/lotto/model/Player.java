package lotto.model;

import static lotto.constants.Constant.MINIMUM_LOTTO_PRICE_UNIT;

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
        while (money >= MINIMUM_LOTTO_PRICE_UNIT) {
            money -= MINIMUM_LOTTO_PRICE_UNIT;
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
    }

    public WinningResult calculateResult(WinningNumbers winningNumbers) {
        Calculator calculator = new Calculator(lottos, winningNumbers);
        Map<Rank, Integer> winningStatistics = calculator.calculateStatistics();
        Double winningRate = calculator.calculateWinningRate(winningStatistics, money);
        return new WinningResult(winningStatistics, winningRate);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
