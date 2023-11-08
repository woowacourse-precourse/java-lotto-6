package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("WinningLotto를 생성할 수 있다.")
    void createWinningLottoTest() {
        assertThat(WinningLotto.createWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7))
            .isInstanceOf(WinningLotto.class);
    }

    @Test
    @DisplayName("WinningLotto 생성시 BonusNumber와  Integer List에 중복된 숫자가 있는 경우 예외를 발생시킨다.")
    void createWinningLottoBonusNumberDuplicatedTest() {
        assertThatThrownBy(() -> WinningLotto.createWinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
