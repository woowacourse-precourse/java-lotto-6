package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("WinningLotto 생성 테스트")
    @Test
    void createWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        assertNotNull(winningLotto);
    }

    @DisplayName("중복된 번호가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(List.of(1, 2, 3, 4, 5, 5)));
    }

}