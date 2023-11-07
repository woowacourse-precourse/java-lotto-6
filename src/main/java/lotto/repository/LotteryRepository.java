package lotto.repository;

import lotto.domain.Buyer;
import lotto.dto.LotteryWinningNumbers;

public class LotteryRepository {
    private static final LotteryRepository singleton = new LotteryRepository();

    private Buyer buyer = new Buyer();
    private LotteryWinningNumbers lotteryWinningNumbers = new LotteryWinningNumbers();

    private LotteryRepository(){}

    public static LotteryRepository getInstance() {
        return singleton;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public LotteryWinningNumbers getLotteryWinningNumbers() {
        return lotteryWinningNumbers;
    }

    public void initBuyer() {
        buyer = new Buyer();
    }

    public void initLotteryWinningNumbers() {
        lotteryWinningNumbers = new LotteryWinningNumbers();
    }
}
