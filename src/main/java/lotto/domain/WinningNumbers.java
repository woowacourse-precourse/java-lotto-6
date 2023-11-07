package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    // 생성자
    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        // 입력값의 유효성을 검사하는 validate 메서드 호출
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // 입력값의 유효성을 검사하는 메서드
    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.size() != 6 || !isInRange(winningNumbers, 1, 45) || !isInRange(bonusNumber, 1, 45)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    // 숫자의 범위를 검사하는 메서드
    private boolean isInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }

    // 여러 숫자의 범위를 검사하는 메서드
    private boolean isInRange(List<Integer> numbers, int min, int max) {
        for (int number : numbers) {
            if (!isInRange(number, min, max)) {
                return false;
            }
        }
        return true;
    }

    // 로또 번호와 당첨 번호를 비교하여 Rank(등수)를 계산하는 메서드
    public Rank calculateRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        long matchCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);
        return Rank.valueOf(matchCount, hasBonusNumber);
    }
}
