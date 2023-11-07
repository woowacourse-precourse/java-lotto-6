package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
  private final Lotto lotto;
  
  public WinningLotto(List<Integer> numbers) {
    this.lotto = new Lotto(numbers);
  }
  
  public Lotto getLotto() {
    return lotto;
  }
}
