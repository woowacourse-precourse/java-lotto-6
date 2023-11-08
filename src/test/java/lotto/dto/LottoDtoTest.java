package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoRankings;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoDtoTest {

    @DisplayName("Information를 생성하고, 복제본을 비교한다.")
    @Test
    void informationIntegrationTest() {
        // given
        List<Lotto> readyLotto = new ArrayList<>(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        // when
        Lottos lottos = new Lottos(readyLotto);
        LottoDto.Information information = LottoDto.Information.from(lottos);

        // then
        assertThat(information.getLottos() == readyLotto).isFalse();
        assertThat(information.getLottos()).usingRecursiveComparison().isEqualTo(readyLotto);
    }

    @DisplayName("Information를 생성하고, 복제본을 비교한다.")
    @Test
    void resultIntegrationTest() {
        // given
        LottoRankings rankings = new LottoRankings(
                new ArrayList<>(List.of(LottoRanking.FIRST, LottoRanking.FIRST, LottoRanking.SECOND))
        );
        Map<LottoRanking, Integer> readyResult = new EnumMap<>(LottoRanking.class) {{
            put(LottoRanking.FIRST, 2);
            put(LottoRanking.SECOND, 1);
        }};

        // when
        LottoDto.Result result = LottoDto.Result.from(rankings);

        // then
        assertThat(result.getResult() == readyResult).isFalse();
        assertThat(result.getResult()).usingRecursiveComparison().isEqualTo(readyResult);
    }
}