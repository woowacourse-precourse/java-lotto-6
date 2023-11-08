package lotto.domain.prize;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.lotto.Lotto;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Prize {

    private final List<PrizeNumber> prizeNumbers;
    private final PrizeNumber bonusNumber;

    public Prize(
            final List<PrizeNumber> prizeNumbers,
            final PrizeNumber bonusNumber
    ) {
        validatePrizeNumbers(prizeNumbers);
        validateBonusNumber(prizeNumbers, bonusNumber);

        this.prizeNumbers = sortPrizeNumbers(prizeNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validatePrizeNumbers(final List<PrizeNumber> prizeNumbers) {
        validateSize(prizeNumbers);
        validateDuplicates(prizeNumbers);
        validatePrizeNumberOnlyPrizeType(prizeNumbers);
    }

    private void validateSize(final List<PrizeNumber> prizeNumbers) {
        if (prizeNumbers.size() != Lotto.LOTTO_SIZE) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private void validateDuplicates(final List<PrizeNumber> prizeNumbers) {
        Set<PrizeNumber> setPrizeNumbers = new HashSet<>(prizeNumbers);
        if (setPrizeNumbers.size() != prizeNumbers.size()) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_DUPLICATES);
        }
    }

    private void validatePrizeNumberOnlyPrizeType(final List<PrizeNumber> prizeNumbers) {
        boolean isAllPrizeType = prizeNumbers.stream()
                .allMatch(PrizeNumber::isPrizeType);
        if (!isAllPrizeType) {
            throw LottoException.of(ErrorMessage.INVALID_PRIZE_NUMBER_TYPE);
        }
    }

    private void validateBonusNumber(
            final List<PrizeNumber> prizeNumbers,
            final PrizeNumber bonusNumber
    ) {
        validateBonusNumberType(bonusNumber);
        validateBonusNumberUniqueFromPrizeNumbers(prizeNumbers, bonusNumber);
    }

    private void validateBonusNumberType(final PrizeNumber bonusNumber) {
        if (!bonusNumber.isBonusType()) {
            throw LottoException.of(ErrorMessage.INVALID_BONUS_NUMBER_TYPE);
        }
    }

    private void validateBonusNumberUniqueFromPrizeNumbers(
            final List<PrizeNumber> prizeNumbers,
            final PrizeNumber bonusNumber
    ) {
        final PrizeNumber convertedBonusNumber = new PrizeNumber(
                bonusNumber.getNumber(),
                PrizeNumberType.PRIZE
        );
        if (prizeNumbers.contains(convertedBonusNumber)) {
            throw LottoException.of(ErrorMessage.INVALID_BONUS_NUMBER_NOT_UNIQUE);
        }
    }

    private List<PrizeNumber> sortPrizeNumbers(final List<PrizeNumber> prizeNumbers) {
        final List<PrizeNumber> sortedPrizeNumbers = new ArrayList<>(prizeNumbers);
        sortedPrizeNumbers.sort(Comparator.comparingLong(PrizeNumber::getNumber));
        return sortedPrizeNumbers;
    }

    public boolean isWinWithBonus(
            final Lotto lotto,
            final int matchCount
    ) {
        return isWin(lotto, matchCount) && containsBonusNumber(lotto);
    }

    public boolean isWin(
            final Lotto lotto,
            final int matchCount
    ) {
        final int count = (int) prizeNumbers.stream()
                .filter(lotto::contains)
                .count();
        return count == matchCount;
    }

    public boolean containsBonusNumber(final Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public boolean isWinWithoutBonus(
            final Lotto lotto,
            final int matchCount
    ) {
        return isWin(lotto, matchCount) && !containsBonusNumber(lotto);
    }
}
