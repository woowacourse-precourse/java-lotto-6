package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:false:FOURTH", "3:false:FIFTH",
            "3:true:PASS", "2:false:PASS", "2:true:PASS", "4:true:PASS", "6:true:PASS"},
            delimiter = ':')
    void someTestMethod(int matchNumberCount, boolean bonus, Rank estimate) {
        Rank result = Rank.judge(matchNumberCount, bonus);
        Assertions.assertThat(result).isEqualTo(estimate);
    }

}