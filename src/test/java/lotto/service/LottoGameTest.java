package lotto.service;

import lotto.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @Test
    void 랜덤_생성_로또_번호_개수_테스트() {
        // given
        LottoGame lottoGame = new LottoGame(new User());

        // when, then
        assertEquals(6, lottoGame.generateNewLotto().getNumbers().size());
    }
}