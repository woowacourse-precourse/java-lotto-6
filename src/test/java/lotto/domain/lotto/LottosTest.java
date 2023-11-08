package lotto.domain.lotto;

import lotto.domain.Ranking;
import lotto.domain.generator.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {

    @DisplayName("구입 금액만큼 로또를 생성한다.")
    @Test
    void createLottos() {
        // given
        int purchasePrice = 3000;
        Lottos lottos = new Lottos(LottoNumberGenerator.getInstance(), purchasePrice);

        // then
        Assertions.assertThat(lottos).isNotNull();
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(purchasePrice / LottoCondition.PRICE.getValue());
    }

    @DisplayName("정답 로또와 비교해서 당첨 결과를 반환한다.")
    @Test
    void calculateWinningResult() {
        // given
        AnswerLotto answerLotto = new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lottos lottos = new Lottos(() -> List.of(1, 2, 3, 4, 5, 7), 1000);

        // when
        List<Ranking> rankings = lottos.calculateWinningResult(answerLotto);

        // then
        Assertions.assertThat(rankings.size()).isEqualTo(1);
        Assertions.assertThat(rankings.contains(Ranking.SECOND)).isTrue();
    }
}
