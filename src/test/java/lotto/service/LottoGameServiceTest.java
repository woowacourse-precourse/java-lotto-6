package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGameServiceTest {
    private LottoGameService lottoGameService;

    @BeforeEach
    void setUp() {
        lottoGameService = new LottoGameService();
    }

    @Test
    void 로또_구매_로직_테스트() {
        String lottoCount = lottoGameService.buyLotto("3000");
        assertEquals("3", lottoCount);
    }

    @Test
    void 로또_발행_로직_테스트() {
        lottoGameService.buyLotto("3000");
        assertThat(lottoGameService.makeLotto()).contains(
                "[", ",", "]"
        );
    }
}