package lotto.model;

import java.util.List;

import static lotto.Utils.makeLottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto makeLotto() {
        List<Integer> lottoNumbers = makeLottoNumber();
        return new Lotto(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int checkWinning(Lotto winningLotto, int bonusNumber) {
        int matchCount = 0;
        for (int number : this.numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 6) {
            return 1;
        } else if (matchCount == 5 && this.numbers.contains(bonusNumber)) {
            return 2;
        } else if (matchCount == 5) {
            return 3;
        } else if (matchCount == 4) {
            return 4;
        } else if (matchCount == 3) {
            return 5;
        } else {
            return 0;
        }
    }

}