package lotto.domain;

import java.util.List;

public class Draw {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Draw(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Rank> doDraw(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningNumbers, bonusNumber)).toList();
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateUniqueNumbers(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        final String message = "당첨 번호의 개수는 6개여야 합니다.";
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        final String message = "로또 번호에 중복된 숫자가 있으면 안됩니다.";
        final long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        final String message = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(message);
        }
    }
}
