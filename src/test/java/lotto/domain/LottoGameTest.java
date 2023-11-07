package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private LottoGame lottoGame;

    @DisplayName("setPurchaseAmount 테스트")
    @Test
    void setPurchaseAmount() {
        lottoGame = new LottoGame(8000);
        lottoGame.setPurchaseAmount();
        assertThat(lottoGame.getPurchaseAmount()).isEqualTo(8);
    }

}