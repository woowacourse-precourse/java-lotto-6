package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }
        else if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 중 중복이 있습니다.");
        }
    }

    public int getRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchingNumbers = (int) lottoNumbers.stream().filter(numbers::contains).count();
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

        if (matchingNumbers == 6) {
            return 1;
        } else if (matchingNumbers == 5 && hasBonusNumber) {
            return 2;
        } else if (matchingNumbers == 5) {
            return 3;
        } else if (matchingNumbers == 4) {
            return 4;
        } else if (matchingNumbers == 3) {
            return 5;
        }

        return 0;
    }
}
