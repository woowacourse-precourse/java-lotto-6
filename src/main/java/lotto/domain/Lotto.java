package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER_RANGE = 1;
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;
    private static final int MAX_LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoRange(numbers);
        validateDuplicateLotto(numbers);
        this.numbers = sortedLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개 이어야 합니다.");
        }
    }

    public boolean isContainsLottoNumber(int number) {
        return numbers.contains(number);
    }

    public WinningStatistics judgeLottoRank(Lotto winningLotto, BonusNumber bonusNumber) {
        int match = (int) winningLotto.numbers.stream()
                .filter(numbers::contains)
                .count();

        return WinningStatistics.of(match, bonusNumber.isMatch(numbers));
    }

    private List<Integer> sortedLotto(List<Integer> numbers) {
        List<Integer> sortedLotto = new ArrayList<>(numbers);
        Collections.sort(sortedLotto);
        return sortedLotto;
    }

    private void validateLottoRange(List<Integer> numbers) {
        if (isLottoOverRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력은 1이상 45이하의 숫자만 입력 가능합니다.");
        }
    }

    private boolean isLottoOverRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER_RANGE || number > MAX_LOTTO_NUMBER_RANGE);
    }

    private void validateDuplicateLotto(List<Integer> numbers) {
        if (isDuplicateLotto(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복되었습니다.");
        }
    }

    private boolean isDuplicateLotto(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        return distinctCount != numbers.size();
    }

    public void validateDuplicateWinningLottoNumberAndBonusNumber(BonusNumber bonusNumber) {
        if (isDuplicateWinningLottoNumberAndBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다. 보너스 번호를 다시 입력하세요.");
        }
    }

    private boolean isDuplicateWinningLottoNumberAndBonusNumber(BonusNumber bonusNumber) {
        return isContainsLottoNumber(bonusNumber.getBonusNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
