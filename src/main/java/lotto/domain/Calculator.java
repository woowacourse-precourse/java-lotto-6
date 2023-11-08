package lotto.domain;

import static lotto.constant.Grade.FIFTH;
import static lotto.constant.Grade.FIRST;
import static lotto.constant.Grade.FOURTH;
import static lotto.constant.Grade.NONE;
import static lotto.constant.Grade.SECOND;
import static lotto.constant.Grade.THIRD;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.constant.Grade;

public class Calculator {
    public static Grade checkWinning(Lotto lotto, LottoDrawResult lottoDrawResult) {
        Lotto resultLottoNumbers = lottoDrawResult.getLotto();
        Integer resultBonus = lottoDrawResult.getBonus();

        Integer sameNumbersNumber = obtainEqualNumbersNumber(lotto, resultLottoNumbers);
        Boolean isBonusInLotto = isBonusInLotto(lotto, resultBonus);

        return obtainGrade(sameNumbersNumber, isBonusInLotto);
    }

    private static Integer obtainEqualNumbersNumber(Lotto lotto1, Lotto lotto2) {
        List<Integer> numbers1 = lotto1.getNumbers();
        List<Integer> numbers2 = lotto2.getNumbers();

        List<Integer> IntersectionNumbers = numbers1.stream()
                .filter(old -> numbers2.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());

        return IntersectionNumbers.size();
    }

    private static boolean isBonusInLotto(Lotto lotto, Integer bonus) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(bonus);
    }

    private static Grade obtainGrade(Integer sameNumbersNumber, Boolean isBonusInLotto) {
        if (sameNumbersNumber == Lotto.SIZE) {
            return FIRST;
        }
        if ((sameNumbersNumber == Lotto.SIZE - 1) && isBonusInLotto == true) {
            return SECOND;
        }
        if (sameNumbersNumber == Lotto.SIZE - 1) {
            return THIRD;
        }

        return getThirdAfterGrade(sameNumbersNumber);
    }

    private static Grade getThirdAfterGrade(Integer sameNumbersNumber) {
        if (sameNumbersNumber == Lotto.SIZE - 2) {
            return FOURTH;
        }
        if (sameNumbersNumber == Lotto.SIZE - 3) {
            return FIFTH;
        }

        return NONE;
    }

    public static Double returnRate(List<Lotto> lottos, LottoDrawResult lottoDrawResult) {
        final Integer PERCENTILE_UNIT = 100;

        Integer purchaseCnt = lottos.size();
        Integer purchaseMoney = purchaseCnt * Lotto.PRICE;
        Integer winningMoney = 0;

        for (int i = 0; i < purchaseCnt; i++) {
            Grade grade = checkWinning(lottos.get(i), lottoDrawResult);
            winningMoney += grade.getPrize();
        }

        return Double.valueOf(winningMoney) * PERCENTILE_UNIT / purchaseMoney;
    }
}
