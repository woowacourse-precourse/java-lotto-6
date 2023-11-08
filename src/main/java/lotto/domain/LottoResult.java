package lotto.domain;

import lotto.type.LottoPrize;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    public static final int SECOND_MATCHING_CORRECT_NUM = 5;
    private static final double PERCENT = 100.0;
    private final List<Lotto> purchasedLottos;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoResult(List<Lotto> purchasedLottos, Lotto winningNumbers, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoPrize> calculateResults() {
        return purchasedLottos.stream()
                .map(this::matchLotto)
                .collect(Collectors.toList());
    }

    public double calculateReturnRatio(List<LottoPrize> prizes, int purchaseAmount) {
        int totalPrize = prizes.stream()
                .mapToInt(LottoPrize::getPrize)
                .sum();

        return ((double) totalPrize / purchaseAmount) * PERCENT;
    }

    public LottoPrize matchLotto(Lotto lotto) {
        int matchedNumber = countMatchingNumbers(lotto);

        if (matchedNumber == SECOND_MATCHING_CORRECT_NUM) {
            return LottoPrize.valueOf(matchedNumber, isMatchBonusNumber(lotto));
        }

        return LottoPrize.valueOf(matchedNumber, false);
    }

    public int countMatchingNumbers(Lotto lotto) {
        return winningNumbers.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .toList()
                .size();
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}