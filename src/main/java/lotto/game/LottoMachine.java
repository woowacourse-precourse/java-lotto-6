package lotto.game;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Balance;
import lotto.domain.Lotto;
import lotto.strategy.IssuanceStrategy;

public class LottoMachine {
    private final IssuanceStrategy issuanceStrategy;

    private LottoMachine(IssuanceStrategy issuanceStrategy) {
        this.issuanceStrategy = issuanceStrategy;
    }

    public static LottoMachine create(IssuanceStrategy issuanceStrategy) {
        return new LottoMachine(issuanceStrategy);
    }

    public List<Lotto> purchaseAll(Balance balance) {
        List<Lotto> lottos = new ArrayList<>();

        while (balance.hasSufficientBalance()) {
            Lotto lotto = purchase(balance);
            lottos.add(lotto);
        }

        return lottos;
    }

    private Lotto purchase(Balance balance) {
        balance.deductTicketPrice();
        return issuanceStrategy.issue();
    }
}
