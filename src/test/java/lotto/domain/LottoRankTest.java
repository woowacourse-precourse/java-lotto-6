package lotto.domain;

import static lotto.domain.LottoRank.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {
    @DisplayName("[Success] 로또 결과에 알맞은 Rank를 리턴한다.")
    @Test
    void returnExactRank() {
        assertThat(LottoRank.findLottoRank(6, false))
                .isEqualTo(FIRST);
    }

    @DisplayName("[Success] 상수 메시지를 formatting하여 당첨 기준에 맞는 메시지를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST, '6개 일치 (2,000,000,000원) - '",
            "SECOND, '5개 일치, 보너스 볼 일치 (30,000,000원) - '",
            "THIRD, '5개 일치 (1,500,000원) - '",
            "FOURTH, '4개 일치 (50,000원) - '",
            "FIFTH, '3개 일치 (5,000원) - '",
    })
    void returnExactMessage(LottoRank rank, String message) {
        assertThat(rank.getMessage())
                .isEqualTo(message);
    }
}
