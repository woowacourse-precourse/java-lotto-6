package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInRange(numbers);
        validateNumbersIsDuplicated(numbers);
        this.numbers = numbers;
    }

    //Set에 담은 후 Lotto의 숫자 개수(6)만큼 빼면 교집합 -> 로또 숫자 갯수 - 교집합 = 당첨 등수
    public int compareToPlayerLotto(WinningLotto playerLotto) {
        Set<Integer> winningNumber = new HashSet<>(playerLotto.numbers().getNumbers());
        winningNumber.addAll(numbers);
        int count = winningNumber.size() - LottoNumbers.LOTTO_SIZE.getNumber();
        return LottoNumbers.LOTTO_SIZE.getNumber() - count;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LottoNumbers.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 6개의 로또 번호만 입력할 수 있습니다.");
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateNumberInRange(int number) {
        if (number < LottoNumbers.MIN_LOTTO_NUMBER.getNumber()
                || number > LottoNumbers.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45까지의 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateNumbersIsDuplicated(List<Integer> numbers) {
        Set<Integer> copyNumbers = new HashSet<>(numbers);
        if (copyNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되었습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
