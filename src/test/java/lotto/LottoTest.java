package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
  @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
  @Test
  void createLottoByOverSize() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void createLottoByDuplicatedNumber() {
    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  // 아래에 추가 테스트 작성 가능
  @DisplayName("보너스 번호와 겹치는 숫자를 찾을 수 있다.")
  @Test
  void matchWithBonusNumber() {
    List<Integer> numbers = List.of(1,2,3,4,5,6);
    List<Integer> matchedBonusNumber = List.of(1,2,3,4,5,6);
    List<Integer> unmatchedBonusNumber = List.of(7,8,9,10);

    Lotto lotto = new Lotto(numbers);

    for(Integer number : matchedBonusNumber) {
      assertThat(lotto.matchWithBonusNumber(number)).isEqualTo(true);
    }
    for(Integer number : unmatchedBonusNumber) {
      assertThat(lotto.matchWithBonusNumber(number)).isEqualTo(false);
    }
  }
}