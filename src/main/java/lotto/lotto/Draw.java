package lotto.lotto;

import java.util.List;

public class Draw {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Draw(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Rank> doDraw(List<Lotto> lottoList) {
        return lottoList.stream()
                .map(lotto -> lotto.match(winningNumbers, bonusNumber)).toList();
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateUniqueNumbers(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        final long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException("당첨 번호에 중복된 숫자가 있으면 안됩니다.");
        }
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
