package lotto.domain.service;

import java.util.List;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoGenerator;
import lotto.domain.entity.LottoManager;
import lotto.domain.entity.User;
import lotto.domain.service.dto.GameResult;

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

    public GameResult calculateResult(
            final List<Integer> numbers,
            final int bonusNumber,
            final User user
    ) {
        Lotto lotto = new Lotto(numbers);
        LottoManager lottoManager = new LottoManager(lotto, bonusNumber);
        lottoManager.calculateTotalRanking(user.getLottos());

        return new GameResult(
                lottoManager.getRankBoard(),
                user.calculateEarningRate(
                        lottoManager.getTotalPrize()
                )
        );
    }
}
