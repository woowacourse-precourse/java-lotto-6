package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.domain.WinningLottoNumbers;

public class LottoCountService {

    private static final int FIVE_NUMBERS_MATCHED = 5;
    private static final int SIX_NUMBERS_MATCHED = 6;
    private static final int FIVE_NUMBERS_MATCHED_AND_NOT_BONUS_CASE = 5;
    private static final int FIVE_NUMBERS_MATCHED_AND_BONUS_CASE = 6;
    private static final int SIX_NUMBERS_MATCHED_CASE = 7;
    private static final int[] PRIZE_AMOUNTS = {0, 0, 0, 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};


    public Match countMatching(List<Lotto> userPurchasedLotto, WinningLottoNumbers winningLottoNumbers, Bonus bonus) {

        Match matchResult = new Match();

        userPurchasedLotto.forEach(lotto -> {
            matchResult.incrementMatchCount(countSingleMatching(lotto, winningLottoNumbers, bonus));
        });

        return matchResult;
    }

    private int countSingleMatching(Lotto singleLotto, WinningLottoNumbers winningLottoNumbers, Bonus bonus) {

        int matchCount = (int) singleLotto.getNumbers().stream()
                .filter(number -> winningLottoNumbers.getNumbers().contains(number))
                .count();

        if (matchCount == FIVE_NUMBERS_MATCHED) {

            return countBonus(singleLotto, bonus);

        } else if (matchCount == SIX_NUMBERS_MATCHED) {

            return SIX_NUMBERS_MATCHED_CASE;

        }

        return matchCount;

    }

    private int countBonus(Lotto singleLotto, Bonus bonus) {

        boolean hasBonus = singleLotto.getNumbers().stream()
                .anyMatch(number -> singleLotto.getNumbers().contains(bonus.getBonusNumber()));

        if (!hasBonus) {
            return FIVE_NUMBERS_MATCHED_AND_NOT_BONUS_CASE;
        }

        return FIVE_NUMBERS_MATCHED_AND_BONUS_CASE;

    }

    public double countProfit(Match matchResult, int lottoAmount) {

        double lottoInvest = lottoAmount * 1000;

        double lottoReturn = 0;
        int index = 0;
        for (int matchSingleResult : matchResult.getMatchCounts()) {
            lottoReturn += matchSingleResult * PRIZE_AMOUNTS[index++];
        }

        return Math.round(lottoReturn / lottoInvest * 1000) / 10.0;

    }
}
