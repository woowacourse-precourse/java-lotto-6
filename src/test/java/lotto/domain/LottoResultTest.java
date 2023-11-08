package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @DisplayName("로또 결과를 생성하여 랭킹 별로 개수를 저장한다.")
    @Test
    void makeResult() {
        //given
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1,2,3,4,5,6))));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new BonusBall(7));
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        //when
        lottoResult.makeResult();

        //then
        assertThat(lottoResult.get(Ranking.FIRST)).isEqualTo(1);
    }

    @DisplayName("로또 결과를 생성하여 수익률을 계산한다.")
    @Test
    void getProfitRate() {
        //given
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1,2,3,4,5,6))));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new BonusBall(7));
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        //when
        lottoResult.makeResult();

        //then
        assertThat(lottoResult.getProfitRate()).isEqualTo(200_000_000);
    }
}