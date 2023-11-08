package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {

    @DisplayName("로또 번호 갯수가 6개 초과시 예외")
    @Test
    void createWinLottoByOverSize() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6, 7), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중복시 예외")
    @Test
    void createWinLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 6, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
