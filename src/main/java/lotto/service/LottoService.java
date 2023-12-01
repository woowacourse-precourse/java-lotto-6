package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.service.dto.Result;

public class LottoService {

    private static final LottoService instance = new LottoService();

    private final LottoGenerator lottoGenerator = LottoGenerator.getInstance();

    private LottoService() {
    }

    public static LottoService getInstance() {
        return instance;
    }

    public LottoBundle createLottoBundle(int purchasePrice) {
        return lottoGenerator.generateLottoBundle(purchasePrice);
    }

    public Lotto createLotto(final List<Integer> numbers) {
        return lottoGenerator.createLotto(numbers);
    }

    public BonusNumber createBonusNumber(final int number, final Lotto winningLotto) {
        return lottoGenerator.createBonusNumber(number, winningLotto);
    }

    public Result createResult(LottoBundle lottoBundle, Lotto winningLotto,
            BonusNumber bonusNumber) {

        Map<Rank, Integer> totalRankWithCount = lottoBundle.calculateTotalRank(winningLotto,
                bonusNumber);

        int totalPrize = totalRankWithCount.keySet()
                .stream()
                .mapToInt(rank -> rank.multiple(totalRankWithCount.get(rank)))
                .sum();

        float earningRate = lottoBundle.calculateEarningRate(totalPrize);

        return Result.of(totalRankWithCount, earningRate);
    }
}
