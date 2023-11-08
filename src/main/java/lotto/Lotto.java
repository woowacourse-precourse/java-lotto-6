package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        } else if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

  public List<Integer> getNumbers(){
    return this.numbers;
  }


  public void printLotto(){
    System.out.println(this.numbers.stream().sorted().collect(Collectors.toList()));
  }
}
