package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;
    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validateUnique(numbers,bonusNumber);
        validateRange(bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank compareNumbers(List<Integer> lottoNumbers) {
        int match = 0;
        boolean bonus = false;
        for (int i = 0; i < 6; i++) {
            if (checkNumber(lottoNumbers.get(i))) {
                match += 1;
            }
            if (lottoNumbers.get(i) == bonusNumber) {
                bonus = true;
            }
        }
        return LottoRank.whichRank(match, bonus);
    }

    public boolean checkNumber(int lottoNumber) {
        for (int number : numbers) {
            if (lottoNumber == number) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateUnique(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호입니다.");
        }
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
