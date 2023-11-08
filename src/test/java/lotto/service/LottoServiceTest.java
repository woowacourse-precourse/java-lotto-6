package lotto.service;

import lotto.constant.LottoRank;
import lotto.domain.Lotto;

import lotto.domain.LottoGameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.NumericConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    @Test
    @DisplayName("구입되는 로또의 수량은 구매금액에서 로또가격을 나눈 값이어야 한다.")
    void buyLotto() {
        LottoService lottoService = new LottoService();
        int money = 5000;

        List<Lotto> lottos = lottoService.buyLotto(5000);
        assertThat(lottos.size()).isEqualTo(money / LOTTO_PRICE);
    }


    @Test
    @DisplayName("로또 게임의 결과가 올바르게 반환되는지 테스트")
    void getResultOfLottos() {
        LottoService lottoService = new LottoService();
        int money = 10_000;

        lottoService.buyLotto(10_000); //로또 10장 구입

        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        LottoGameResult result = lottoService.getResultOfLottos(winningLotto, bonusNumber);

        int lottoCount = 0;
        for (LottoRank rank : LottoRank.values()) {
            lottoCount += result.getNumberOfRank(rank);
        }

        Assertions.assertThat(lottoCount).isEqualTo(10); // 10장 구입
    }
}