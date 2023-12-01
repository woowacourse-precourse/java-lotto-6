package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoExecutor;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.service.dto.Result;

public class LottoService {

    private static final LottoService instance = new LottoService();

    private final LottoGenerator lottoGenerator = LottoGenerator.getInstance();
    private final LottoExecutor lottoExecutor = LottoExecutor.getInstance();

    private LottoService() {
    }

    public static LottoService getInstance() {
        return instance;
    }

    public LottoBundle createLottoBundle(final int purchasePrice) {
        return lottoGenerator.generateLottoBundle(purchasePrice);
    }

    public Lotto createLotto(final List<Integer> numbers) {
        return lottoGenerator.createLotto(numbers);
    }

    public BonusNumber createBonusNumber(final int number, final Lotto winningLotto) {
        return lottoGenerator.createBonusNumber(number, winningLotto);
    }

    public Result createResult(
            final LottoBundle lottoBundle,
            final Lotto winningLotto,
            final BonusNumber bonusNumber
    ) {

        return lottoExecutor.execute(
                lottoBundle,
                winningLotto,
                bonusNumber
        );
    }
}
