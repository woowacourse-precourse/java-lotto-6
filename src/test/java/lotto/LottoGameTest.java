package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {
    @DisplayName("로또를 주어진 숫자 만큼 구매 할 수 있다.")
    @Test
    void buyLotto() {
        LottoGame lottoGame = new LottoGame();
        int quantitiy = 6;
        lottoGame.buy(quantitiy);

        assertThat(lottoGame.getLottos().size()).isEqualTo(6);
    }
}