package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoInfo;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.ExceedsMaxLottoNumberException;
import lotto.exception.InvalidLottoSizeException;
import lotto.exception.LessThanMinLottoNumberException;
import lotto.vo.BonusNumber;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createWinningLotto(List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    public static Lotto createLotto(final LottoNumberGenerator lottoNumberGenerator) {
        return new Lotto(getLottoNumbers(lottoNumberGenerator));
    }

    private static List<Integer> getLottoNumbers(final LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> randomNumbers = lottoNumberGenerator.pickNumbers();
        randomNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(randomNumbers);

        return Collections.unmodifiableList(randomNumbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LottoInfo.LOTTO_SIZE.getValue()) {
            throw new InvalidLottoSizeException();
        }
        if (hasDuplicateNumber(numbers)) {
            throw new DuplicateLottoNumberException();
        }
        if (hasLargerThanMaxNumber(numbers)) {
            throw new ExceedsMaxLottoNumberException();
        }
        if (hasLessThanMinNumber(numbers)) {
            throw new LessThanMinLottoNumberException();
        }
    }

    private boolean hasDuplicateNumber(final List<Integer> numbers) {
        Set<Integer> numberGroup = new HashSet<>(numbers);
        return numbers.size() != numberGroup.size();
    }

    private boolean hasLargerThanMaxNumber(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> (number > LottoInfo.LOTTO_MAX_NUMBER.getValue()));
    }

    private boolean hasLessThanMinNumber(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> (number < LottoInfo.LOTTO_MIN_NUMBER.getValue()));
    }

    public int countMatchedNumber(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(number -> lotto.contain(number))
                .count();
    }

    public boolean isContainBonusNumber(final BonusNumber bonusNumber) {
        return this.contain(bonusNumber.number());
    }

    public boolean contain(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
