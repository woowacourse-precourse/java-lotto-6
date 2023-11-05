package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

class WinningLottoTest {
    @Test
    void createWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new LottoNumber(7));
        winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new LottoNumber(7));
    }
}