package lotto.domain;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.UserInputNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

  @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
  @Test
  void createLottoByOverSize() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호의 범위가 1~45가 아닌 경우 예외가 발생한다.")
  @Test
  void createLottoByInvalidNumber() {
    assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")
  @Test
  void createLottoByDuplicatedNumber() {
    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("getMatchCount()는 로또 번호와 일치하는 번호의 수를 반환한다.")
  @Test
  void testGetMatchCount() {
    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumbers);
    UserInputNumbers userInputNumbers = new UserInputNumbers(lottoNumbers, 7);
    int matchCount = lotto.getMatchCount(userInputNumbers);
    assertThat(matchCount).isEqualTo(6);
  }

  @DisplayName("isBonusMatch()는 로또 번호와 보너스 번호가 일치하면 true를 반환한다.")
  @Test
  void testIsBonusMatch() {
    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumbers);
    UserInputNumbers userInputNumbers = new UserInputNumbers(lottoNumbers, 7);
    boolean isBonusMatch = lotto.isBonusMatch(userInputNumbers);
    assertThat(isBonusMatch).isFalse(); // 보너스 번호는 7이므로 일치하지 않아야 함
  }
}
