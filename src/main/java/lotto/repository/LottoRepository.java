package lotto.repository;

import lotto.domain.Buyer;
import lotto.dto.LotteryWinningNumbers;

public class LottoRepository {
    private static final LottoRepository singleton = new LottoRepository();

    private Buyer buyer = new Buyer();
    private LotteryWinningNumbers lotteryWinningNumbers = new LotteryWinningNumbers();

    private LottoRepository(){}

    public static LottoRepository getInstance() {
        return singleton;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public LotteryWinningNumbers getLotteryWinningNumbers() {
        return lotteryWinningNumbers;
    }
}
