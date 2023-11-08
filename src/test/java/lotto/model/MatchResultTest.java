package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchResultTest {
    private Lottos lottos;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        MainNumbers mainNumbers = MainNumbers.from(List.of("1", "2", "3", "4", "5", "6"));
        BonusNumber bonusNumber = BonusNumber.from("10");
        lottos = Lottos.assemble(() -> List.of(1, 2, 3, 4, 5, 10), 3);
        winningNumbers = WinningNumbers.of(mainNumbers, bonusNumber);
    }

    @DisplayName("우승 번호와 로또 번호를 비교하여 매칭 결과를 계산한다.")
    @Test
    void calculateMatchResults() {
        MatchResult matchResult = MatchResult.calculateMatchResults(lottos, winningNumbers);

        assertThat(matchResult.getMatchResult().size()).isEqualTo(5);
        assertThat(matchResult.getMatchResult().get(LottoRank.SIX_MATCHES)).isEqualTo(0);
        assertThat(matchResult.getMatchResult().get(LottoRank.FIVE_MATCHES_WITH_BONUS)).isEqualTo(3);
        assertThat(matchResult.getMatchResult().get(LottoRank.FIVE_MATCHES)).isEqualTo(0);
        assertThat(matchResult.getMatchResult().get(LottoRank.FOUR_MATCHES)).isEqualTo(0);
        assertThat(matchResult.getMatchResult().get(LottoRank.THREE_MATCHES)).isEqualTo(0);
    }

}
