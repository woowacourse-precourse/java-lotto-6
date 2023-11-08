package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
  private final List<Integer> numbers;
  
  /*
   * Lotto 객체를 생성하는 생성자.
   * 입력받은 번호가 유효한지 검증한다.
   * */
  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }
  
  /*
   * 입력받은 번호가 유효한지 검증하는 메서드.
   * 6개의 번호가 아니거나 중복된 번호가 있으면 예외를 던진다.
   * */
  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException();
    }
    
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != 6) {
      throw new IllegalArgumentException();
    }
  }
  
  //다른 Lotto 객체와 일치하는 번호의 개수를 반환하는 메서드.
  public int countMatchedNumbers(Lotto other) {
    return (int) numbers.stream()
        .filter(other.numbers::contains)
        .count();
  }
  
  //특정 번호가 이 Lotto 객체에 포함되어 있는지 확인하는 메서드.
  public boolean contains(int number) {
    return this.numbers.contains(number);
  }
  
  //  Lotto 객채를 문자열로 변환하는 메서드. 로또 번호를 출력할 때 사용.
  @Override
  public String toString() {
    return numbers.toString();
  }
}