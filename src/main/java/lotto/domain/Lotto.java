package lotto.domain;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ExceptionMessage;

public class Lotto {
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validateSize(numbers);
    validateDuplicate(numbers);
    validateRange(numbers);

    Collections.sort(numbers);
    this.numbers = numbers;
  }
  public List<Integer> getLottoNumbers() {
    return numbers;
  }

  // 당첨로또랑 같은거 카운트
  public int countMatch(Lotto winningLotto) {
    return (int) numbers.stream().
      filter(winningLotto::containNumber).
      count();
  }
  // 당첨로또와 같은게 있는지 T/F
  public boolean containNumber(int number) {
    return numbers.contains(number);
  }


  private void validateSize(List<Integer> numbers) {
    if (numbers.size() != 6) {
      ExceptionMessage.sizeException();
      throw new IllegalArgumentException();
    }
  }

  private void validateDuplicate(List<Integer> numbers) {
    Set<Integer> duplicateCheck = new HashSet<>();
    for (int i = 0; i < numbers.size(); i++) {
      duplicateCheck.add(numbers.get(i));
    }

    if (duplicateCheck.size() != 6) {
      ExceptionMessage.overlapException();
      throw new IllegalArgumentException();
    }
  }

  private void validateRange(List<Integer> numbers) {
    for (int num = 0; num < numbers.size(); num++) {
      if (numbers.get(num) < MIN_NUMBER || numbers.get(num) > MAX_NUMBER) {
        ExceptionMessage.rangeException();
        throw new IllegalArgumentException();
      }

    }
  }

  // 당첨번호랑 보너스번호 중복 체크
  public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
    if (numbers.contains(bonusNumber)) {
      ExceptionMessage.overlapException();
      throw new IllegalArgumentException();
    }
  }

}
