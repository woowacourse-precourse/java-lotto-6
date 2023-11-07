package lotto.model;

import static lotto.util.constants.Numbers.BONUS_INCLUDED_START_RANK;
import static lotto.util.constants.Numbers.BONUS_NOT_INCLUDED_START_RANK;
import static lotto.util.constants.Numbers.FIRST_PRIZE_MATCH_COUNT;
import static lotto.util.constants.Strings.LOTTO_BONUS_PAIR_STRING_FORMAT;
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
        return publishedLotto.getPublishedLotto()
                .stream()
                .map(this::checkRank)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return LOTTO_BONUS_PAIR_STRING_FORMAT.getFormat(winnerNumbers, bonusNumber);
    }

    private Integer checkRank(Lotto lotto) {
        Integer correctNumbers = winnerNumbers.countSameNumbers(lotto);
        if (isFirstPrize(correctNumbers)) {
            return 1;
        }
        return calculateRank(lotto, correctNumbers);
    }

    private boolean isFirstPrize(int correctNumbers) {
        return correctNumbers == FIRST_PRIZE_MATCH_COUNT.getNumber();
    }

    private int calculateRank(Lotto lotto, int correctNumbers) {
        if (lotto.contains(bonusNumber)) {
            return BONUS_INCLUDED_START_RANK.getNumber() - correctNumbers;
        }
        return BONUS_NOT_INCLUDED_START_RANK.getNumber() - correctNumbers;
    }

    private void validate(Lotto winnerNumbers, Integer bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw LottoException.of(WINNER_NUMBER_CONTAINS_BONUS);
        }
    }
}
