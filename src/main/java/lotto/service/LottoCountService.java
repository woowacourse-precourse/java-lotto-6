package lotto.service;

import java.util.List;
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


    public Match countMatching(List<Lotto> userPurchasedLotto, WinningLottoNumbers winningLottoNumbers, Bonus bonus) {

        Match match = new Match();

        userPurchasedLotto.forEach(lotto -> {
            match.incrementMatchCount(countSingleMatching(lotto, winningLottoNumbers, bonus));
        });

        return match;
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
}
