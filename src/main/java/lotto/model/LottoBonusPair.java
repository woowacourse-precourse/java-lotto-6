package lotto.model;

import static lotto.util.exception.ErrorMessage.WINNER_NUMBER_CONTAINS_BONUS;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.exception.LottoException;

public class LottoBonusPair {
    private final Lotto winnerNumbers;
    private final Integer bonusNumber;

    LottoBonusPair(Lotto winnerNumbers, Integer bonusNumber) {
        validate(winnerNumbers, bonusNumber);
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoBonusPair getInstance(Lotto winnerNumbers, Integer bonusNumber) {
        return new LottoBonusPair(winnerNumbers, bonusNumber);
    }

    public List<Integer> getResults(PublishedLotto publishedLotto) {
        return publishedLotto.getPublishedLottos()
                .stream()
                .map(this::checkRank)
                .collect(Collectors.toList());
    }

    private Integer checkRank(Lotto lotto) {
        boolean hasBonusNumber = lotto.contains(bonusNumber);
        Integer correctNumbers = winnerNumbers.compare(lotto);
        if (correctNumbers == 6) {
            return 1;
        }
        if (hasBonusNumber) {
            return 7 - correctNumbers;
        }
        return 8 - correctNumbers;
    }

    private void validate(Lotto winnerNumbers, Integer bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw LottoException.of(WINNER_NUMBER_CONTAINS_BONUS);
        }
    }
}
