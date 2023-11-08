package lotto.domain;

import static lotto.domain.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankingTest {
    @Test
    @DisplayName("일치 횟수에 해당하는 Ranking을 반환하는 테스트")
    void findByMatchCount_test() {
        assertThat(Ranking.findByMatchCount(3)).isEqualTo(THREE_MATCHES);
        assertThat(Ranking.findByMatchCount(4)).isEqualTo(FOUR_MATCHES);
        assertThat(Ranking.findByMatchCount(6)).isEqualTo(SIX_MATCHES);
    }

    @Test
    @DisplayName("일치 횟수가 5라면 보너스 번호를 비교해 해당 Ranking을 반환하는 테스트")
    void compareLottoWithBonusNumber_test() {
        Lotto lottoTest = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int matchBonusNumberTest = 6;
        int nonMatchBonusNumberTest = 45;

        assertThat(Ranking.compareLottoWithBonusNumber(lottoTest, matchBonusNumberTest))
                .isEqualTo(FIVE_MATCHES_BONUS_MATCHES);
        assertThat(Ranking.compareLottoWithBonusNumber(lottoTest, nonMatchBonusNumberTest))
                .isEqualTo(FIVE_MATCHES);
    }
}
