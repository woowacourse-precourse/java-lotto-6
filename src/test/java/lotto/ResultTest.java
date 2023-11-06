package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("Result는 당첨결과 `Rank`를 모두 가지고 있다")
    @Test
    void lottoResultTest() {
        Lotto first = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        Lotto third = Lotto.from(List.of(1, 2, 3, 4, 5, 45));
        Lotto fourth = Lotto.from(List.of(1, 2, 3, 4, 44, 45));
        Lotto fifth = Lotto.from(List.of(1, 2, 3, 43, 44, 45));
        Lotto nothing = Lotto.from(List.of(40, 41, 42, 43, 44, 45));

        List<Lotto> lottos = List.of(first, second, third, fourth, fifth, nothing);
        LottoNumber bonus = LottoNumber.getInstance(7);
        WinLotto winLotto = WinLotto.of(first, bonus);

        LottoResult lottoResult = LottoResult.of(lottos, winLotto);
        Map<Rank, Integer> result = lottoResult.getResult();
        assertNotNull(lottoResult);

        assertThat(result.getOrDefault(Rank.FIRST, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.SECOND, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.THIRD, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.FOURTH, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.FIFTH, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.NOTHING, 0)).isEqualTo(1);

        long expected = 2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + 5_000;
        assertEquals(lottoResult.getTotalPrize(), expected);
    }
}
