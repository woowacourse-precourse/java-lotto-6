package lotto;

import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Prize.*;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 구성됩니다.");
    }
    for(int i=0; i<numbers.size(); i++) {
      for(int j=i+1; j<numbers.size(); j++) {
        if (numbers.get(i) == numbers.get(j))
          throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 6개의 숫자로 구성됩니다.");
      }
      if(numbers.get(i) < 1 || 45 < numbers.get(i))
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 정수이어야 합니다.");
    }
  }

  public static List<Integer> generateLotto() {
    List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
    return numbers;
  }

  public Boolean matchWithBonusNumber(Integer bonusNumber) {
    for(Integer number : numbers) {
      if (number == bonusNumber) return true;
    }
    return false;
  }

  public Prize getScore(Lotto winningLotto, Integer bonusNumber) {
    Integer score = 0;
    for(Integer number : numbers) {
      for(Integer winningnumber : winningLotto.numbers) {
        if(number == winningnumber) score++;
      }
    }
    if(score == 6)
      return FIRST_PRIZE;
    if(score == 5 && this.matchWithBonusNumber(bonusNumber))
      return SECOND_PRIZE;
    if(score == 5)
      return THIRD_PRIZE;
    if(score == 4)
      return FOURTH_PRIZE;
    if(score == 3)
      return FIFTH_PRIZE;
    return FAIL;
  }
}
