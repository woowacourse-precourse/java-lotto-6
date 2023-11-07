package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1개의 로또를 발행할 때 6개의 숫자만 존재합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또번호는 중복 숫자가 있어서는 안됩니다.");

    }

    @DisplayName("발행된 로또의 6개의 숫자의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByBeyondScope() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("발행된 로또 번호가 그대로 저장되있어야 한다")
    @Test
    void consistentLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("반환된 로또 번호는 수정이 되면 예외처리")
    @Test
    void throwExceptionWhenModifyGetLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> cpyLotto = lotto.getNumbers();
        assertThatThrownBy(() -> cpyLotto.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("로또에 적힌 숫자를 출력할 수 있다")
    @Test
    void printLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 14));
        assertThat(lotto.toString())
                .isEqualTo("[1, 2, 3, 4, 5, 14]");
    }
}