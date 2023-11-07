package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private Money money;
    private Money initialInvestment;
    private List<Lotto> lottos;
    private Set<Lotto> alreadyWinningLottos = new HashSet<>();
    public User(Money money) {
        this.money = money;
        this.initialInvestment = money;
        this.lottos = new ArrayList<>();
    }

    public boolean buy(Money lottoPrice, Lotto lotto) {
        if(money.hasNotMoney()) {
            return false;
        }

        money = money.minus(lottoPrice);
        lottos.add(lotto);

        return true;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public int calculateWinningCount(Winning winning, WinningLotto winningLotto) {
        return (int) lottos.stream()
                .filter(lotto -> isWinningLotto(winning, winningLotto, lotto))
                .count();
    }

    private boolean isWinningLotto(Winning winning, WinningLotto winningLotto, Lotto lotto) {
        boolean match = winningLotto.isMatch(winning, lotto);
        if (match) {
            return alreadyWinningLottos.add(lotto);
        }
        return false;
    }

    public double calculateRateOfReturn(Money totalProfit) {
        return initialInvestment.calculateRateOfReturn(totalProfit.plus(initialInvestment));
    }



}
