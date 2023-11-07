package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {
            "6:true:FIRST",
            "6:false:FIRST",
            "5:true:SECOND",
            "5:false:THIRD",
            "4:true:FOURTH",
            "4:false:FOURTH",
            "3:true:FIFTH",
            "3:false:FIFTH",
            "2:true:NOTHING",
            "1:false:NOTHING"} , delimiter = ':')
    void getRankTest(int count, Boolean hasbonusNumber, LottoRank expected) {
        LottoRank rank = LottoRank.of(count, hasbonusNumber);
        Assertions.assertThat(rank).isEqualTo(expected);
    }
}