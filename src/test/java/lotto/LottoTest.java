package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Prize.*;
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

  @DisplayName("로또 번호의 일치하는 개수를 정확히 계산한다.")
  @Test
  void getScore() {
    Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
    Integer bonusNumber = 7;

    Lotto firstPrizeLotto = new Lotto(List.of(1,2,3,4,5,6));
    Lotto secondPrizeWithBonusLotto = new Lotto(List.of(2,3,4,5,6,7));
    Lotto secondPrizeLotto = new Lotto(List.of(2,3,4,5,6,8));
    Lotto thirdPrizeLotto = new Lotto(List.of(3,4,5,6,7,8));
    Lotto fourthPrizeLotto = new Lotto(List.of(4,5,6,7,8,9));
    Lotto failedPrizeLotto1 = new Lotto(List.of(5,6,7,8,9,10));
    Lotto failedPrizeLotto2 = new Lotto(List.of(6,7,8,9,10,11));
    Lotto failedPrizeLotto3 = new Lotto(List.of(7,8,9,10,11,12));

    assertThat(firstPrizeLotto.getScore(winningLotto, bonusNumber)).isEqualTo(FIRST_PRIZE);
    assertThat(secondPrizeWithBonusLotto.getScore(winningLotto, bonusNumber)).isEqualTo(SECOND_PRIZE);
    assertThat(secondPrizeLotto.getScore(winningLotto, bonusNumber)).isEqualTo(THIRD_PRIZE);
    assertThat(thirdPrizeLotto.getScore(winningLotto, bonusNumber)).isEqualTo(FOURTH_PRIZE);
    assertThat(fourthPrizeLotto.getScore(winningLotto, bonusNumber)).isEqualTo(FIFTH_PRIZE);
    assertThat(failedPrizeLotto1.getScore(winningLotto, bonusNumber)).isEqualTo(FAIL);
    assertThat(failedPrizeLotto2.getScore(winningLotto, bonusNumber)).isEqualTo(FAIL);
    assertThat(failedPrizeLotto3.getScore(winningLotto, bonusNumber)).isEqualTo(FAIL);
  }
}