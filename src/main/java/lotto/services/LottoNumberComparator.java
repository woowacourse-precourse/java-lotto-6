package lotto.services;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.LottoPrize;

public class LottoNumberComparator {
    private final List<Lotto> purchasedLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private EnumMap<LottoPrize, Integer> prizeCount;

    public LottoNumberComparator(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
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
            boolean isBonus = isBonusNumberMatched(lotto);
            LottoPrize rank = determinePrize(matchCount, isBonus);

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

    public boolean isBonusNumberMatched(Lotto purchasedLotto) {
        List<Integer> purchasedNumbers = purchasedLotto.getNumbers();
        return purchasedNumbers.contains(bonusNumber);
    }

    private LottoPrize determinePrize(int matchCount, boolean bonus) {
        return LottoPrize.calculate(matchCount, bonus);

    }

    private void updatePrizeCount(LottoPrize rank) {
        if (rank != null) {
            prizeCount.put(rank, prizeCount.get(rank) + 1);
        }
    }
}
