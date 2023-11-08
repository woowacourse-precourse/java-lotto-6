package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.model.calculate.MarginRate;
import lotto.model.calculate.WinningResult;
import lotto.model.dto.LottoPaper;
import lotto.model.dto.LottoResult;
import lotto.model.lotto.Lottos;
import lotto.model.lottoPick.PickedLotto;
import lotto.model.money.Money;

public class Buyer {
    private final Money purchasingMoney;
    private final Lottos lottos;

    public Buyer(final Money purchasingMoney, final Lottos lottos) {
        validate(purchasingMoney, lottos);
        this.purchasingMoney = purchasingMoney;
        this.lottos = lottos;
    }

    private void validate(final Money purchasingMoney, final Lottos lottos) {
        Objects.requireNonNull(purchasingMoney);
        Objects.requireNonNull(lottos);
    }

    public List<LottoPaper> getLottoPapers() {
        return lottos.createLottoPapers();
    }

    public LottoResult createLottoResult(PickedLotto pickedLotto) {
        final WinningResult winningResult = lottos.createWinningResult(pickedLotto);
        final Money revenue = winningResult.calculateTotalRevenue();
        final MarginRate marginRate = new MarginRate(this.purchasingMoney, revenue);

        return new LottoResult(winningResult, marginRate);
    }
}
