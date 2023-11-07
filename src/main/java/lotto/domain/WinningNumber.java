package lotto.domain;

import java.util.List;

public class WinningNumber {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final int SMALLEST_LOTTO_NUMBER = 1;
    private static final int LARGEST_LOTTO_NUMBER = 45;
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
        for (int i = 0; i < NUMBER_OF_LOTTO_NUMBERS; i++) {
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

    private void validateUnique(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호입니다.");
        }
    }

    private void validateRange(int number) {
        if (number < SMALLEST_LOTTO_NUMBER || number > LARGEST_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
