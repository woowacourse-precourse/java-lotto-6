package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPrizeTest {

    @DisplayName("일치 번호 갯수와 보너스 번호 포함 여부가 주어지면, 순위가 반환된다.")
    @ParameterizedTest(name = "일치 갯수={0}, 보너스={1}, expected={2}")
    @CsvSource(value = {"6:false:FIRST_PRIZE", "5:true:SECOND_PRIZE", "5:false:THIRD_PRIZE", "4:false:FOURTH_PRIZE", "3:false:FIFTH_PRIZE", "2:false:NOTHING_PRIZE", "1:false:NOTHING_PRIZE", "0:false:NOTHING_PRIZE"}, delimiter = ':')
    void getPrizeRankTest(int matchNumbers, boolean isMatchBonus, LottoPrize expected) {
        Assertions.assertThat(LottoPrize.getPrizeRank(matchNumbers, isMatchBonus))
                .isEqualTo(expected);
    }

}