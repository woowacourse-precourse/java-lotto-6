package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @DisplayName("[SUCCESS]맞춘 번호 개수와 보너스볼 일치 유무로 등수를 찾는다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0,false,FAIL",
            "3,false,FIFTH",
            "4,false,FOURTH",
            "5,false,THIRD",
            "5,true,SECOND",
            "6,false,FIRST"
    })
    void checkLottoRankFoundedByCountAndBonusBall(int count, boolean bonus, LottoRank expected) {
        assertThat(LottoRank.findLottoRank(count, bonus)).isEqualTo(expected);
    }


    @DisplayName("[SUCCESS]특정 등수에 대해 당첨된 로또 개수만큼의 보상을 받을 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {
            "FAIL,1,0",
            "FIFTH,1,5_000",
            "FOURTH,1,50_000",
            "THIRD,1,1_500_000",
            "SECOND,1,30_000_000",
            "FIRST,1,2_000_000_000"
    })
    void checkCalculateRewardPerRank(LottoRank rank, int count, int expected) {
        assertThat(rank.calculateReward(count)).isEqualTo(expected);
    }


    @DisplayName("[SUCCESS]특정 등수에 대해 형식에 맞는 보상 문자열을 가져올 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {
            "FAIL:0",
            "FIFTH:5,000",
            "FOURTH:50,000",
            "THIRD:1,500,000",
            "SECOND:30,000,000",
            "FIRST:2,000,000,000"
    }, delimiter = ':')
    void checkFormattedReward(LottoRank rank, String expected) {
        assertThat(rank.getFormattedReward()).isEqualTo(expected);
    }
}