package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    WinningLotto winningLotto;
    @BeforeEach
    @Test
    void createWinningLotto() {
        winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new LottoNumber(7));
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외 발생")
    @Test
    void createWinningLottoByContainNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new LottoNumber(2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}