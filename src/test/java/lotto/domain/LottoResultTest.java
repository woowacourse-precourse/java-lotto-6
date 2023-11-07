package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    public void 로또_번호_비교_테스트() {
        //given
        LottoResult lottoResult = new LottoResult();
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // FIRST
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // SECOND
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)), // THIRD
                new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), //FIFTH
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)) //NONE
        ));

        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int bonusNumber = 7;

        //when
        Map<Rank, Integer> results = lottoResult.compareLotto(lottos, winningLotto, bonusNumber);

        //then
        assertThat(results)
                .hasEntrySatisfying(Rank.FIRST, count -> assertThat(count).isEqualTo(1))
                .hasEntrySatisfying(Rank.SECOND, count -> assertThat(count).isEqualTo(1))
                .hasEntrySatisfying(Rank.THIRD, count -> assertThat(count).isEqualTo(1))
                .hasEntrySatisfying(Rank.FIFTH, count -> assertThat(count).isEqualTo(1))
                .hasEntrySatisfying(Rank.NONE, count -> assertThat(count).isEqualTo(1));

        assertThat(results.size()).isEqualTo(5);

    }

}