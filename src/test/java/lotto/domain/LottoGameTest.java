package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoGameTest {

    @DisplayName("구매 수량만큼 로또 번호 세트를 생성합니다")
    @Test
    void createLottoGame() {
        // given
        int buyingPrice = 10000;

        // when
        LottoGame lottoGame = LottoGame.createLottoGame(buyingPrice);
        List<Lotto> lottos = lottoGame.getLottos();

        // then
        assertThat(lottos.size()).isEqualTo(10);
    }
}