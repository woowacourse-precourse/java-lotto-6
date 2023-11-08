package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Buyer {
    private Lotto lotto;
    private int bonus;

    private Buyer(Lotto lotto, int bonus) {
        this.lotto = lotto;

        validateExistence(bonus);

        this.bonus = bonus;
    }

    public static Buyer create(Lotto lotto, int bonus) {
        return new Buyer(lotto, bonus);
    }

    private void validateExistence(int bonus) {
        if (isExistedValue(bonus)) {
            throw new LottoException(ErrorMessage.IS_EXISTED_VALUE);
        }
    }

    private boolean isExistedValue(int bonus) {
        return lotto.contain(bonus);
    }

    public Rank calculateComparingResult(Lotto numbers) {
        int matchNumber = countMatchNumber(numbers);
        boolean hasBonus = hasBonus(numbers);

        return Arrays.stream(Rank.values())
                .map(rank -> rank.rankByCondition(matchNumber, hasBonus))
                .findFirst()
                .orElse(Rank.NONE);
    }

    private int countMatchNumber(Lotto numbers) {
        List<Integer> lottoNumbers = numbers.getLottoNumbers();

        return (int) lottoNumbers.stream()
                .filter(this.lotto::contain)
                .count();
    }

    private boolean hasBonus(Lotto numbers) {
        return numbers.contain(bonus);
    }
}
