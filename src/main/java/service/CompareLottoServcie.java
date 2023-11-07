package service;

import static util.CountEqualAccordRank.FIFTH_EQUAL_COUNT;
import static util.CountEqualAccordRank.FIRST_EQUAL_COUNT;
import static util.CountEqualAccordRank.FOURTH_EQUAL_COUNT;
import static util.CountEqualAccordRank.THIRD_EQUAL_COUNT;
import static util.LottoRankNumber.FIFTH;
import static util.LottoRankNumber.FIRST;
import static util.LottoRankNumber.FOURTH;
import static util.LottoRankNumber.OTHER;
import static util.LottoRankNumber.THIRD;

import domain.Amount;
import domain.Lottos;
import domain.Rank;
import domain.WinningNumbers;
import java.util.ArrayList;
import java.util.List;

public class CompareLottoServcie {

    public static Rank calculateRank(Amount amount, Lottos lottos, WinningNumbers winningNumbers) {
        List<Integer> equalNumbersCount = winningNumbers.equalNumbersCount(lottos);
        List<Boolean> isEqualBonusNumber = winningNumbers.isEqualBonusNumber(lottos);

        List<Integer> lottoRank = new ArrayList<>();
        for (int i = 0; amount.isLargerThen(i); i++) {
            if (isEqualBonusNumber.get(i)) {
                lottoRank.add(haveBonusNumberRank(equalNumbersCount.get(i)));
                continue;
            }
            lottoRank.add(noHaveBonusNumberRank(equalNumbersCount.get(i)));
        }

        return MakeObjectService.rank(lottoRank);
    }

    private static int haveBonusNumberRank(int equalCount) {
        if (equalCount < FIFTH_EQUAL_COUNT.get() - 1) {
            return rankCalculator(equalCount);
        }
        return rankCalculator(equalCount) - 1;
    }

    private static int noHaveBonusNumberRank(int equalCount) {
        return rankCalculator(equalCount);
    }

    private static int rankCalculator(int equalCount) {
        if (equalCount == FIFTH_EQUAL_COUNT.get()) {
            return FIFTH.get();
        }
        if (equalCount == FOURTH_EQUAL_COUNT.get()) {
            return FOURTH.get();
        }
        if (equalCount == THIRD_EQUAL_COUNT.get()) {
            return THIRD.get();
        }
        if (equalCount == FIRST_EQUAL_COUNT.get()) {
            return FIRST.get();
        }
        return OTHER.get();
    }
}