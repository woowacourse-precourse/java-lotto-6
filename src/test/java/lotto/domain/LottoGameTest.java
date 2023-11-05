package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoGameTest {

    @DisplayName("구매 수량만큼 로또 번호 세트를 생성한다.")
    @Test
    void createLottoGame() {
        // given
        int buyingPrice = 10000;

        // when
        LottoGame lottoGame = LottoGame.createLottoGame(buyingPrice);
        List<Lotto> lottos = lottoGame.getLottos();

        // then
        assertThat(lottos.size()).isEqualTo(10);
        assertThat(lottoGame.getBuyingAmount()).isEqualTo(10);
    }

    @DisplayName("당첨 번호 정보로부터 당첨 통계 정보를 반환한다.")
    @Test
    void calculateWinning() {
        // given
        WinningLotto winningLotto = WinningLotto.of(List.of(1, 2, 3, 4, 5, 6));
        int buyingPrice = 10000;
        LottoGame lottoGame = LottoGame.createLottoGame(buyingPrice);

        // when
        WinningResult winningResult = lottoGame.calculateWinning(winningLotto);

        // then
        assertThat(winningResult).isNotNull();
    }
}