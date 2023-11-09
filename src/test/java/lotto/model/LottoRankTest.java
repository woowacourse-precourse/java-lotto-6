package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

    @DisplayName("당첨 번호와 보너스 번호를 비교하여 로또 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3,false", "4, false", "5, false", "5, true", "6, false"})
    void calculateRank(int matchCount, boolean matchBonus) {
        // given & when
        LottoRank lottoRank1 = LottoRank.calculateRank(3, false);
        LottoRank expected1 = LottoRank.FIFTH;

        LottoRank lottoRank2 = LottoRank.calculateRank(4, false);
        LottoRank expected2 = LottoRank.FOURTH;

        LottoRank lottoRank3 = LottoRank.calculateRank(5, false);
        LottoRank expected3 = LottoRank.THIRD;

        LottoRank lottoRank4 = LottoRank.calculateRank(5, true);
        LottoRank expected4 = LottoRank.SECOND;

        LottoRank lottoRank5 = LottoRank.calculateRank(6, false);
        LottoRank expected5 = LottoRank.FIRST;

        // then
        Assertions.assertThat(lottoRank1).isEqualTo(expected1);
        Assertions.assertThat(lottoRank2).isEqualTo(expected2);
        Assertions.assertThat(lottoRank3).isEqualTo(expected3);
        Assertions.assertThat(lottoRank4).isEqualTo(expected4);
        Assertions.assertThat(lottoRank5).isEqualTo(expected5);
    }
}
