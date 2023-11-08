package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.generator.LottoGenerator;
import lotto.service.manager.LottoManager;
import lotto.domain.User;
import lotto.service.dto.GameResult;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public User createUser(final long purchasePrice) {
        return new User(
                lottoGenerator.generate(
                        User.calculatePurchaseAmount(purchasePrice)
                ),
                purchasePrice
        );
    }

    public Lotto createTargetLotto(final List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public GameResult calculateResult(
            final Lotto target,
            final int bonusNumber,
            final User user
    ) {
        LottoManager lottoManager = new LottoManager(target, bonusNumber);
        lottoManager.calculateTotalRanking(user.getLottos());

        return new GameResult(
                lottoManager.getRankBoard(),
                user.calculateEarningRate(
                        lottoManager.getTotalPrize()
                )
        );
    }
}
