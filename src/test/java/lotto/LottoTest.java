package lotto;

import lotto.domain.Lotto;
import lotto.util.Convert;
import lotto.util.ExceptionHandling;
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

    @DisplayName("로또 번호에 범위밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력받은 숫자가 올바르지 않으면 예외가 발생한다.")
    @Test
    void isPurchaseAmountNumber() {
        assertThatThrownBy(() -> ExceptionHandling.isValidNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력받은 숫자가 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void isPurchaseAmountValid() {
        assertThatThrownBy(() -> ExceptionHandling.isValidPrice(5200))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 숫자가 중복된 숫자이면 예외가 발생한다.")
    @Test
    void isBonusNumberValid() {
        assertThatThrownBy(() -> ExceptionHandling.isSameBonusNumber(List.of(1,3,5),5))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨번호와 로또의 중복 갯수를 파악한다.")
    @Test
    void 로또와_당첨번호_중복_확인() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int result = lotto.countMatchingNumbers(List.of(4,5,6,7,8,9));
        assertThat(result).isEqualTo(3);
    }
    @DisplayName("당첨번호와 보너스 숫자의 중복 유무를 파악한다.")
    @Test
    void 로또와_보너스번호_중복_확인() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        boolean result = lotto.isContainBonusNumber(5);
        assertThat(result).isEqualTo(true);
    }

}