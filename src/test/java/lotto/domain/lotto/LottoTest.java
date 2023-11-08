package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.lotto.LottoCondition.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호를 생성한다.")
    @Test
    void createLottoSuccess() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 " + COUNT.getValue() + "개이어야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호가 1에서 45 사이의 값이 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 " + MIN_NUMBER.getValue() + "부터 " + MAX_NUMBER.getValue() + " 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 " + MIN_NUMBER.getValue() + "부터 " + MAX_NUMBER.getValue() + " 사이의 숫자여야 합니다.");
    }

    @DisplayName("사용자 로또와 정답 로또를 비교하여 일치하는 값의 개수를 반환한다.")
    @Test
    void compareToLottoNumbers() {
        // given
        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        Lotto answerLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        int result = userLottoNumbers.compareToLottoNumbers(answerLottoNumbers);

        // then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("사용자 로또와 보너스 번호를 비교하여 일치 여부를 반환한다.")
    @Test
    void compareToBonusNumber() {
        // given
        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        int bonusNumber = 1;

        // when
        boolean result = userLottoNumbers.compareToBonusNumber(bonusNumber);

        // then
        assertThat(result).isTrue();
    }
}
