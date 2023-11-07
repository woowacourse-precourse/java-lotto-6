package lotto.domain;

import lotto.configure.DomainConfiguration;

import java.util.List;

public class LottoManager {
    private final WinningNumbers winningNumbers;
    private final List<Lotto> lottoPurchased;
    private final int purchasePrice;

    public LottoManager(WinningNumbers winningNumbers, List<Lotto> lottoPurchased) {
        this.winningNumbers = winningNumbers;
        this.lottoPurchased = lottoPurchased;
        this.purchasePrice = lottoPurchased.size() * DomainConfiguration.PRICE_OF_LOTTO;
    }

    /**
     * 발행된 로또를 처리한다.
     * @return 로또 결과를 포함한 Result 객체.
     */
    public Result processLotto() {
        Result result = new Result();
        this.lottoPurchased.forEach((lotto) -> processALotto(result, lotto));
        return result;
    }

    private void processALotto(Result result, Lotto lotto) {
        int numOfMatches = lotto.compare(this.winningNumbers);
        if (!DomainConfiguration.RANK_PER_NUM_OF_MATCHES.containsKey(numOfMatches)) {
            return;
        }
        Integer rank = DomainConfiguration.RANK_PER_NUM_OF_MATCHES.get(numOfMatches);
        if (rank == DomainConfiguration.RANK_FOR_CHECK_BONUS_NUMBER) {
            rank += getOneIfBonusNumberMatches(lotto, this.winningNumbers.getBonusNumber());
        }
        result.addCount(rank);
    }

    private int getOneIfBonusNumberMatches(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    public int getPurchasePrice() {
        return this.purchasePrice;
    }
}
