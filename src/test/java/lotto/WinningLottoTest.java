package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @DisplayName("당첨 로또 번호의 입력된 개수(보너수 점수 제외)가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7),8))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 로또 번호의 입력된 개수(보너스 점수 제외)개수가 6개 아래면 예외가 발생한다.")
    @Test
    void createLottoByLowerSize() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5),6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5),6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6),6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 맞고 중복된 숫자가 없으면 정상적으로 생성됨")
    @Test
    void createValidWinningLotto() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(validNumbers,7);
        assertThat(winningLotto.getNumbers()).isEqualTo(validNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

}
