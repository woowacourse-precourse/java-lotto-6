package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import lotto.enums.LottoPrize;

public class LottoNumberComparator {
    private final List<Lotto> purchasedLottos;
    private final Lotto winningLotto;
    private EnumMap<LottoPrize, Integer> prizeCount;

    public LottoNumberComparator(List<Lotto> purchasedLottos, Lotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.prizeCount = new EnumMap<>(LottoPrize.class);
        initializePrizeCount();
        calculatePrizes();
    }

    public EnumMap<LottoPrize, Integer> getPrizeCount() {
        return prizeCount;
    }

    private void initializePrizeCount() {
        for (LottoPrize rank : LottoPrize.values()) {
            prizeCount.put(rank, 0);
        }
    }

    private void calculatePrizes() {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = calculateMatchingNumbers(lotto);
            LottoPrize rank = determinePrize(matchCount);
            updatePrizeCount(rank);
        }
    }

    public int calculateMatchingNumbers(Lotto purchasedLotto) {
        int matchCount = 0;
        List<Integer> winningNumbers = winningLotto.getNumbers();
        List<Integer> purchasedNumbers = purchasedLotto.getNumbers();
        for (int number : purchasedNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private LottoPrize determinePrize(int matchCount) {
        return LottoPrize.getPrizeByMatchCount(matchCount);

    }

    private void updatePrizeCount(LottoPrize rank) {
        if (rank != null) {
            prizeCount.put(rank, prizeCount.get(rank) + 1);
        }
    }
}
