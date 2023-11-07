package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoGameTest {
    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    void getLottoTest() {
        Lotto lotto = lottoGame.getLotto();
        assertNotNull(lotto);
    }

    @Test
    void checkLottoTest() {
        lottoGame.setWinningLotto(List.of(1, 3, 5, 7, 9, 11));
        lottoGame.setBonusNumber(13);
        assertEquals(0, LottoPrize.SECOND.getCount());
        lottoGame.checkLotto(new Lotto(List.of(1, 3, 5, 7, 9, 13)));
        assertEquals(1, LottoPrize.SECOND.getCount());
    }

}
