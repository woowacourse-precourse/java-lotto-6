package lotto.domain.lotto;

import java.util.List;
import lotto.domain.amount.TotalAmount;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public TotalAmount accumulatePrize(WinningLotto winningLotto) {
        TotalAmount totalAmount = TotalAmount.initial();

        for (Lotto lotto : lottos) {
            LottoPrize prize = winningLotto.matches(lotto);
            totalAmount = totalAmount.addLottoPrize(prize);
        }

        return totalAmount;
    }

    public int count() {
        return lottos.size();
    }
}
