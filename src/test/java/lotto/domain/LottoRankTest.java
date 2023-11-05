package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class LottoRankTest {

    @ParameterizedTest
    @CsvSource({"3,false,FIFTH_RANK", "5,true,SECOND_RANK", "2,true,NO_RANK", "6,false,FIRST_RANK"})
    @DisplayName("당첨 반환 테스트")
    void checkRank(int matchCount, boolean isMatchBonus, String expected) {
        //given
        LottoRank lottoRank = LottoRank.checkRank(matchCount, isMatchBonus);
        String name = lottoRank.name();

        Assertions.assertThat(name).isEqualTo(expected);
    }
}