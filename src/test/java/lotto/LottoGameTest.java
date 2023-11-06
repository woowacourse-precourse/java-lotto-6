package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoGameTest {
    LottoGame lottoGame;
    @BeforeEach
    void setUp(){
        lottoGame = new LottoGame();
    }
    @Test
    void getLottoTest(){
        Lotto lotto = lottoGame.getLotto();
        assertNotNull(lotto);
    }
}
