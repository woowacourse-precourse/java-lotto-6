package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.LottoDraw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoDrawTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new LottoDraw(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 6개의 숫자와 1개의 보너스 번호만 존재합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoDraw(List.of(1, 2, 3, 4, 5, 5), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호 내에는 중복 숫자가 있어서는 안됩니다.");
    }

    @DisplayName("당첨 번호와 보너스번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호와 보너스번호는 중복될 수 없습니다.");
    }

    @DisplayName("발행된 로또의 6개의 숫자의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByBeyondScope() {
        assertThatThrownBy(() -> new LottoDraw(List.of(0, 1, 2, 4, 5, 6), 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new LottoDraw(List.of(1, 2, 3, 4, 5, 45), 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("발행된 로또 번호가 그대로 저장되있어야 한다")
    @Test
    void consistentLottoNumbers() {
        LottoDraw lotto = new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 10);
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getBonusNumber()).isEqualTo(10);
    }

    @DisplayName("반환된 로또 번호는 수정이 되면 예외처리")
    @Test
    void throwExceptionWhenModifyGetLottoNumbers() {
        LottoDraw lotto = new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 20);
        List<Integer> cpyLotto = lotto.getNumbers();
        assertThatThrownBy(() -> cpyLotto.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
