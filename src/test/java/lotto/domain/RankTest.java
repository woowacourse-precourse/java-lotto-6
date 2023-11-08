package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @DisplayName("당첨 개수에 맞게 등수를 반환해 준다.")
    @ParameterizedTest
    @CsvSource(value = {"0:false:NONE", "3:false:FIFTH", "4:false:FOURTH",
            "5:false:THIRD", "5:true:SECOND", "6:false:FIRST"}, delimiter = ':')
    public void 당첨_개수에_맞게_등수를_반환해_준다(int cnt, boolean bonus, Rank rank) {
        Rank prize = Rank.getPrize(cnt, bonus);
        assertThat(prize).isEqualTo(rank);
    }

    @DisplayName("등수에 맞게 상금을 추가해준다")
    @ParameterizedTest
    @CsvSource(value = {"NONE:0", "FIFTH:5000", "FOURTH:50_000",
            "THIRD:1_500_000", "SECOND:30_000_000", "FIRST:2_000_000_000"}, delimiter = ':')
    public void 등수에_맞게_상금을_추가해준다(Rank rank, long reward) {
        assertThat(rank.calculateReward(0)).isEqualTo(reward);
    }
}