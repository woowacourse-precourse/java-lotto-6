package lotto;

import java.util.Collections;
import java.util.List;

import java.util.*;


public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
      validate(numbers);
      List<Integer> sortedNumbers = new ArrayList<>(numbers); // 새로운 리스트를 생성
      Collections.sort(sortedNumbers); // 새로운 리스트를 오름차순으로 정렬
      this.numbers = Collections.unmodifiableList(sortedNumbers); // 정렬된 리스트를 불변 리스트로 만듦
  }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public int countMatchNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}


