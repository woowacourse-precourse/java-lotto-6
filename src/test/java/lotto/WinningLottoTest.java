package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("보너스의 번호가 45를 넘어가면 에러 발생")
    void createWinningLottoByOverBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5,6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스의 번호가 로또번호랑 중복되면 에러")
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1,2,3,4,5,6), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
