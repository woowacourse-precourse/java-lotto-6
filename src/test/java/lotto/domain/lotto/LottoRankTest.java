package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @DisplayName("당첨 번호 개수와 보너스 번호 포함 여부에 따라 로또 당첨 순위를 판별")
    @ParameterizedTest
    @CsvSource({
            "6, false, 2_000_000_000, FIRST",
            "5, true, 30_000_000, SECOND",
            "5, false, 1_500_000, THIRD",
            "4, false, 50_000, FOURTH",
            "3, false, 5_000, FIFTH",
            "0, false, 0, NONE"
    })
    void should_Determine_LottoRank(
            int matchCount,
            boolean hasBonusNumber,
            long prize,
            LottoRank expectedLottoRank
    ) {
        LottoRank lottoRank = LottoRank.of(matchCount, hasBonusNumber);
        assertThat(lottoRank).isEqualTo(expectedLottoRank);
    }
}