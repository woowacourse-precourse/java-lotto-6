package lotto.domain;

import static lotto.domain.enums.LottoNumberRules.EXACT_LOTTO_COUNTS;
import static lotto.exception.ExceptionMessage.BONUS_NUMBER_ALREADY_CONTAINS_IN_WINNING_NUMBERS;
import static lotto.exception.ExceptionMessage.LOTTO_COUNTS_INVALID;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBERS_DUPLICATED;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertToLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(String.format(LOTTO_COUNTS_INVALID.getMessage(), numbers.size()));
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(String.format(LOTTO_NUMBERS_DUPLICATED.getMessage(), numbers));
        }
    }

    private static boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != EXACT_LOTTO_COUNTS.getValue();
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != EXACT_LOTTO_COUNTS.getValue();
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean contains(LottoNumber bonusNumber) {
        return this.numbers.stream()
                .anyMatch(bonusNumber::equals);
    }

    public LottoNumber hasSameNumber(int inputBonusNumber) {
        LottoNumber bonusNumber = new LottoNumber(inputBonusNumber);
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    String.format(BONUS_NUMBER_ALREADY_CONTAINS_IN_WINNING_NUMBERS.getMessage(),
                            this.numbers.stream()
                                    .map(LottoNumber::getNumber)
                                    .toList(),
                            inputBonusNumber));
        }
        return bonusNumber;
    }

    public RankPrize determineRank(Lotto winningNumbers, LottoNumber bonusNumber) {
        int matchCounts = this.matchCounts(winningNumbers);
        boolean isBonusMatched = this.contains(bonusNumber);
        return RankPrize.determineRankPrize(matchCounts, isBonusMatched);
    }

    private int matchCounts(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
