package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import lotto.exception.DuplicateNumberException;
import lotto.exception.SizeNotEqualException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicate(numbers);
        this.lottoNumbers = convertLottoNumbers(numbers);
    }

    public static Lotto randomPick() {
        List<Integer> numbers = pickUniqueNumbersInRange(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER,
                LOTTO_SIZE);
        return new Lotto(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new SizeNotEqualException(LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new DuplicateNumberException();
        }
    }

    private List<LottoNumber> convertLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public List<LottoNumber> getSortedLottoNumbers() {
        return lottoNumbers.stream()
                .sorted()
                .toList();
    }
}
