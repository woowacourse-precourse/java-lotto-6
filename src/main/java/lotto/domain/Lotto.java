package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  public static final int MIN_LOTTO_NUMBER = 1;
  public static final int MAX_LOTTO_NUMBER = 45;
  public static final int SIZE_OF_LOTTO = 6;
  private List<Integer> lottoNumbers;

  public Lotto(List<Integer> lottoNumbers) {
    validateLottoNumbers(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public int getMatchCount(UserInputNumbers receivedLotto) {
    int matchCount = (int) lottoNumbers.stream()
        .filter(number -> receivedLotto.getReceivedLottoNumbers().contains(number))
        .count(); // count() 메서드는 반환 값이 long이다. int로 캐스팅 해야한다.
    return matchCount;
  }

  public boolean isBonusMatch(UserInputNumbers receivedLotto) {
    return lottoNumbers.contains(receivedLotto.getBonusNumber());
  }

  private void validateLottoNumbers(List<Integer> lottoNumbers) {
    if (lottoNumbers.size() != SIZE_OF_LOTTO) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다.");
    }

    for (int number : lottoNumbers) {
      if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
      }
    }

    Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
    if (uniqueNumbers.size() < lottoNumbers.size()) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
    }
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }
}
