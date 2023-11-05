package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottosTest {

    @DisplayName("로또 당첨 결과 구하는 테스트(5개 + 보너스 x) : 당첨 결과를 담은 로또 결과를 반환한다.")
    @Test
    void getLottoWinningResultFiveMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);
        Lottos userLottos = new Lottos(lottos);

        List<LottoResult> results = userLottos.getLottoWinningResult(
                new Lotto(List.of(2, 3, 4, 5, 6, 7))
                , new BonusNumber(30)
        );

        assertThat(results.size()).isEqualTo(1);
        assertThat(results).containsExactly(LottoResult.FIVE_MATCH);
    }

    @DisplayName("로또 당첨 결과 구하는 테스트(5개 + 보너스 o) : 당첨 결과를 담은 로또 결과를 반환한다.")
    @Test
    void getLottoWinningResultFiveMatchWithBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);
        Lottos userLottos = new Lottos(lottos);

        List<LottoResult> results = userLottos.getLottoWinningResult(
                new Lotto(List.of(2, 3, 4, 5, 6, 7))
                , new BonusNumber(1)
        );

        assertThat(results.size()).isEqualTo(1);
        assertThat(results).containsExactly(LottoResult.FIVE_MATCH_WITH_BONUS);
    }

    @DisplayName("로또 당첨 결과 구하는 테스트 : 당첨결과를 담은 로또 결과를 반환한다.")
    @Test
    void getLottoWinningResult() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);
        Lottos userLottos = new Lottos(lottos);

        List<LottoResult> results = userLottos.getLottoWinningResult(
                new Lotto(List.of(4, 5, 6, 7, 8, 9))
                , new BonusNumber(10)
        );

        assertThat(results.size()).isEqualTo(3);
        assertThat(results).containsExactly(
                LottoResult.THREE_MATCH,
                LottoResult.THREE_MATCH,
                LottoResult.THREE_MATCH);
    }

    @DisplayName("생성 테스트 : List<Lotto>를 갖는 Lottos 객체를 생성한다.")
    @Test
    void create() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        assertThatCode(() -> new Lottos(lottos))
                .doesNotThrowAnyException();
    }
}