package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.message.LottoExceptionMessage;

public class Lotto {
    private static final int REQUIRED_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = create(numbers);
    }

    private void validate(List<Integer> target) {
        validateSize(target);
        validateDuplicate(target);
    }

    private List<LottoNumber> create(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .distinct()
                .sorted()
                .toList();
    }

    private void validateSize(List<Integer> target) {
        if (target.size() != REQUIRED_COUNT) {
            throw new IllegalArgumentException(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }
    }

    private void validateDuplicate(List<Integer> target) {
        Set<Integer> uniqueNumbers = new HashSet<>(target);

        if (uniqueNumbers.size() != target.size()) {
            throw new IllegalArgumentException(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_UNIQUE.getError());
        }
    }

    public int countMatchingNumbers(Lotto target) {
        int matchCounts = 0;
        for (LottoNumber targetLottoNumber : target.lottoNumbers) {
            if (this.lottoNumbers.contains(targetLottoNumber)) {
                matchCounts++;
            }
        }
        return matchCounts;
    }

    public boolean isContains(LottoNumber target) {
        return this.lottoNumbers.contains(target);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }

}
