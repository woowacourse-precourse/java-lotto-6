package lotto;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto() {
    this.numbers = createLottoByDuplicatedNumber();
  }

  public List<Integer> createLottoByDuplicatedNumber() {
    List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    validate(randomNumbers);
    return randomNumbers;
  }


  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR]로또 번호는 6개여야 합니다.");
    }
    Set<Integer> uniqueNumbers = new HashSet<>();
    for (int number : numbers) {
      if (uniqueNumbers.contains(number)) {
        throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
      }
      uniqueNumbers.add(number);
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public List<Lotto> generateMultipleLotto(int count) {
    List<Lotto> lottoList = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      lottoList.add(new Lotto());
    }
    return lottoList;
  }
}