package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 발행 테스트")
class WinningLottoTest {
    @Test
    void 보너스_번호_범위_테스트() {
        assertThatThrownBy(()-> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 보너스 번호는 1부터 45까지 존재합니다.");
    }

    @Test
    void 보너스_번호_중복_테스트() {
        assertThatThrownBy(()-> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 6, 5)), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 로또 번호에 보너스 번호와 중복된 번호가 존재합니다.");
    }
}