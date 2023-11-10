package model;

import view.PrintError;

import java.util.*;

public class WinningLotto {

  private List<Integer> numbers;
  private Integer bonusNumber;
  private final PrintError printError = new PrintError();


  public WinningLotto() {

  }

  // 생성자 : 당첨 번호와 보너스 넘버를 입력 받아 검증하고 저장한다.
  public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
    validateNumbers(numbers);
    validateBonusNumber(numbers, bonusNumber);

    this.numbers = sortNumbers(numbers);
    this.bonusNumber = bonusNumber;
  }

  // 당첨 번호를 반환한다.
  public List<Integer> getNumbers() {
    return numbers;
  }

  // 보너스 번호를 반환한다.
  public Integer getBonusNumber() {
    return bonusNumber;
  }

  // numbers 검증 로직
  public void validateNumbers(List<Integer> numbers) {
    validateNumbersRange(numbers);
    validateSize(numbers);
    validateNumbersDuplicated(numbers);
  }

  // bonusNumber 검증 로직
  public void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
    checkNumberRange(bonusNumber);
    validateNumbersBonusNumbersDuplicated(numbers, bonusNumber);
  }


  // 로또 번호들을 입력 받으면 하나씩 범위를 검증하는 로직을 수행한다.
  public void  validateNumbersRange(List<Integer> numbers) {
    for(Integer number : numbers) {
      checkNumberRange(number);
    }
  }

  // 1~45인지 숫자의 범위를 검증한다.
  public void checkNumberRange(Integer number) {
    if(number < 1 || number > 45) {
      printError.numberRangeMessage();
      throw new IllegalArgumentException();
    }
  }

  // 숫자의 갯수가 6개인지 검증한다.
  public void validateSize(List<Integer> numbers) {
    if (numbers.size() != 6) {
      printError.numberSizeMessage();
      throw new IllegalArgumentException();
    }
  }

  // 로또 번호가 중복인지 검증한다.
  public void validateNumbersDuplicated(List<Integer> numbers) {
    Set<Integer> duplicatedChecker = new HashSet<>();
    for(Integer number : numbers) {
      duplicatedChecker.add(number);
    }
    if(duplicatedChecker.size() != 6) {
      printError.numberDuplicatedMessage();
      throw new IllegalArgumentException();
    }
  }

  // 로또 번호와 보너스 번호가 중복인지 검증한다.
  public void validateNumbersBonusNumbersDuplicated(List<Integer> numbers, Integer bonusNumber) {
    Set<Integer> duplicateChecker = new HashSet<>();
    for(Integer number : numbers) {
      duplicateChecker.add(number);
    }
    duplicateChecker.add(bonusNumber);

    if(duplicateChecker.size() != 7) {
      printError.numberBonusNumberDuplicatedMessage();
      throw new IllegalArgumentException();
    }
  }

  // 로또 번호를 오름차순으로 정렬한다.
  public List<Integer> sortNumbers(List<Integer> numbers) {
    List<Integer> sortNumbers = new ArrayList<>(numbers);
    Collections.sort(sortNumbers);
    return sortNumbers;
  }




}
