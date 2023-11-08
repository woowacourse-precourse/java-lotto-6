package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Domain.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("로또 번호에 45보다 큰 정수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,48,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("로또 번호에 1보다 작은 정수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,0,6,15,29)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 정수만 입력할 수 있습니다.\n");
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[Error] 쉼표(,)로 구분했을 때 6개의 정수로 이루어져야 합니다.\n");
    }

    @DisplayName("로또 번호와 일치하는 개수를 정확히 도출하는 지 테스트")
    @Test
    void testMatchingNumbers() {
        Lotto lotto = new Lotto(List.of(1,5,16,29,30,45));
        assertThat(lotto.calculateLottoResults(List.of(1,5,16,20,26,39)))
                .isEqualTo(3);
    }

    @DisplayName("보너스 번호가 포함이 안 되었을 때 false를 정확히 도출하는 지 테스트")
    @Test
    void testNotContainBonusNumber() {
        Lotto lotto = new Lotto(List.of(1,5,16,29,30,45));
        assertThat(lotto.bonusNumberCheck(4))
                .isEqualTo(false);
    }

    @DisplayName("보너스 번호가 포함 되었을 때 true를 정확히 도출하는 지 테스트")
    @Test
    void testContainBonusNumber() {
        Lotto lotto = new Lotto(List.of(1,5,16,29,30,45));
        assertThat(lotto.bonusNumberCheck(16))
                .isEqualTo(true);
    }
}