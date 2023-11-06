package lotto.service;

import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.LottoPrize;
import lotto.model.PurchaseAmount;
import lotto.model.LottoStatistic;
import lotto.model.WinningNumbers;

public class LottoService {

    public Lottos generateLottos(final PurchaseAmount amount) {
        int lottoCount = amount.toInt() / PurchaseAmount.LOTTO_PRICE;
        return Lottos.from(Stream.generate(this::createLotto)
                .limit(lottoCount)
                .sorted()
                .toList());
    }

    public LottoStatistic generateStatistic(final Lottos lottos, final WinningNumbers winningNumbers) {
        LottoStatistic statistic = LottoStatistic.create();
        lottos.stream()
                .map(winningNumbers::match)
                .map(LottoPrize::from)
                .forEach(statistic::add);
        return statistic;
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
