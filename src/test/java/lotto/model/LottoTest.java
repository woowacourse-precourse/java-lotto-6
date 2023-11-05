package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_생성_테스트_번호가_6개_초과인_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void 로또_생성_테스트_번호가_6개_미만인_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 범위가 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_생성_테스트_번호가_정해놓은_범위가_아닌_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_생성_테스트_로또_번호에_중복이_있는_경우() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 6, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 로또 번호와 비교하여 몇개의 숫자가 일치하는지 개수를 계산하는 함수다. 일치하는 개수가 틀리면 예외가 발생한다.")
    @Test
    void compare_테스트() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 30, 31));
        assertThat(lotto1.matchedCount(lotto2))
                .isEqualTo(4);
    }
}
