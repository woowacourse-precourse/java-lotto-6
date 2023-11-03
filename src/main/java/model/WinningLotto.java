package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

  private final List<Integer> numbers;
  private final Integer bonusNumber;


  public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
    validateNumbersRange(numbers);
    checkNumberRange(bonusNumber);
    validateSize(numbers);
    validateDuplicated(numbers, bonusNumber);

    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  public void  validateNumbersRange(List<Integer> numbers) {
    for(Integer number : numbers) {
      checkNumberRange(number);
    }
  }

  public void checkNumberRange(Integer number) {
    if(number < 1 || number > 45) {
      throw new IllegalArgumentException();
    }
  }

  public void validateSize(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException();
    }
  }

  public void validateDuplicated(List<Integer> numbers, Integer bonusNumber) {
    Set<Integer> duplicateChecker = new HashSet<>();
    for(Integer number : numbers) {
      duplicateChecker.add(number);
    }
    duplicateChecker.add(bonusNumber);

    if(duplicateChecker.size() != 7) {
      throw new IllegalArgumentException();
    }
  }



}
