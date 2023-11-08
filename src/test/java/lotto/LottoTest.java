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
        // 로또 번호가 6개를 초과할 경우 IllegalArgumentException 예외를 발생시키는지 테스트합니다.
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // 로또 번호 중에 중복된 숫자가 있을 경우 IllegalArgumentException 예외를 발생시키는지 테스트합니다.
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 1부터 45 범위 밖이면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRangeNumber() {
        // 로또 번호가 지정된 범위(1~45)를 벗어날 경우 IllegalArgumentException 예외를 발생시키는지 테스트합니다.
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다.");
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        // 로또 번호가 6개 미만일 경우 IllegalArgumentException 예외를 발생시키는지 테스트
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
    }

    @DisplayName("유효한 로또 번호로 로또를 생성한다.")
    @Test
    void createLottoWithValidNumbers() {
        // 유효한 로또 번호로 로또 객체가 올바르게 생성되는지 테스트
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(validNumbers);
    }


}
