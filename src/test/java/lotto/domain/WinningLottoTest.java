package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 보너스_번호와_당첨_번호가_중복될_경우_예외_발생() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호와 당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    void 보너스_번호와_당첨_번호가_서로_다를_경우_예외_미발생() {
        assertThatNoException()
                .isThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7));
    }
}