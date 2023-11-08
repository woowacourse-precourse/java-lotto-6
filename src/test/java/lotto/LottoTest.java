package lotto;

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
  
  @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
  @Test
  void createLottoByDuplicatedNumber() {
    assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
        .isInstanceOf(IllegalArgumentException.class);
  }
  
  //  두 개의 Lotto 객체를 생성, 두 로또의 번호가 일치하는 갯수가 올바르게 반환되는지 확인하는 테스트
  @DisplayName("두 로또의 일치하는 번호의 개수를 반환한다.")
  @Test
  void countMatchedNumbers() {
    Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto lotto2 = new Lotto(List.of(1, 2, 3, 7, 8, 9));
    int count = lotto1.countMatchedNumbers(lotto2);
    assertThat(count).isEqualTo(3);
  }
  
  //  로또가 특정 번호를 포함하고 있는지 확인하는 테스트
  @DisplayName("로또가 특정 번호를 포함하고 있는지 확인한다.")
  @Test
  void contains() {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    boolean contains = lotto.contains(1);
    assertThat(contains).isTrue();
  }
}