package lotto;

import static lotto.Grade.FIFTH;
import static lotto.Grade.FIRST;
import static lotto.Grade.FOURTH;
import static lotto.Grade.SECOND;
import static lotto.Grade.THIRD;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Calculator {
    static public Grade checkWinning(Lotto lotto, LottoDrawResult lottoDrawResult) {
        Lotto resultLottoNumbers = lottoDrawResult.getLotto();
        Integer resultBonus = lottoDrawResult.getBonus();

        Integer sameNumbersNumber = obtainEqualNumbersNumber(lotto, resultLottoNumbers);
        Boolean isBonusInLotto = isBonusInLotto(lotto, resultBonus);

        return obtainGrade(sameNumbersNumber, isBonusInLotto);
    }

    static private Integer obtainEqualNumbersNumber(Lotto lotto1, Lotto lotto2) {
        List<Integer> numbers1 = lotto1.getNumbers();
        List<Integer> numbers2 = lotto2.getNumbers();

        List<Integer> IntersectionNumbers = numbers1.stream()
                .filter(old -> numbers2.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());

        return IntersectionNumbers.size();
    }

    static private boolean isBonusInLotto(Lotto lotto, Integer bonus) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(bonus);
    }

    static private Grade obtainGrade(Integer sameNumbersNumber, Boolean isBonusInLotto) {
        if (sameNumbersNumber == 6) {
            return FIRST;
        }
        if (sameNumbersNumber == 5 && isBonusInLotto == true) {
            return SECOND;
        }
        if (sameNumbersNumber == 5) {
            return THIRD;
        }
        if (sameNumbersNumber == 4) {
            return FOURTH;
        }
        return FIFTH;
    }
}
