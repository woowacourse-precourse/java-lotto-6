package lotto;

import static lotto.model.LottoGame.lottoNumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.Winning;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        validateDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    private List<Integer> validateDuplicates(List<Integer> winningNumbers) {
        Set<Integer> numberSet;
        numberSet = new HashSet<>(winningNumbers);
        if (numberSet.size() != lottoNumbers) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 " + lottoNumbers + "개의 숫자입니다.");
        }

        return winningNumbers;
    }

    public Winning checkWinning(Lotto winningLotto, int bonusNumber) {
        if (this.numbers.equals(winningLotto.numbers)) {
            return Winning.FIRST;
        }
        List<Integer> commonNumbers;
        commonNumbers = winningLotto.numbers.stream()
                .filter(numbers::contains)
                .collect(Collectors.toList());

        if (commonNumbers.size() == 5 && numbers.contains(bonusNumber)) {
            return Winning.SECOND;
        }
        if (commonNumbers.size() == 5) {
            return Winning.THIRD;
        }
        if (commonNumbers.size() == 4) {
            return Winning.FOURTH;
        }
        if (commonNumbers.size() == 3) {
            return Winning.FIFTH;
        }

        return Winning.LOSE;
    }

    public String getNumbers() {
        return numbers.toString();
    }

    public List<Integer> getNumbersList() {
        return numbers;
    }
}
