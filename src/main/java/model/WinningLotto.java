package model;

import view.PrintError;

import java.util.*;

public class WinningLotto {

  private final List<Integer> numbers;
  private final Integer bonusNumber;
  private final PrintError printError = new PrintError();


  public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
    validateNumbersRange(numbers);
    checkNumberRange(bonusNumber);
    validateSize(numbers);
    validateDuplicated(numbers, bonusNumber);

    this.numbers = sortNumbers(numbers);
    this.bonusNumber = bonusNumber;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public Integer getBonusNumber() {
    return bonusNumber;
  }

  public void  validateNumbersRange(List<Integer> numbers) {
    for(Integer number : numbers) {
      checkNumberRange(number);
    }
  }

  public void checkNumberRange(Integer number) {
    if(number < 1 || number > 45) {
      printError.numberRangeMessage();
      throw new IllegalArgumentException();
    }
  }

  public void validateSize(List<Integer> numbers) {
    if (numbers.size() != 6) {
      printError.numberSizeMessage();
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
      printError.numberDuplicatedMessage();
      throw new IllegalArgumentException();
    }
  }

  public List<Integer> sortNumbers(List<Integer> numbers) {
    List<Integer> sortNumbers = new ArrayList<>(numbers);
    Collections.sort(sortNumbers);
    return sortNumbers;
  }




}
