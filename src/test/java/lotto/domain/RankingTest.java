package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankingTest {


    @DisplayName("랭킹 반환 테스트")
    @ParameterizedTest
    @CsvSource({
            "6, true, FIRST",
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, true, FOURTH",
            "4, false, FOURTH",
            "3, true, FIFTH",
            "3, false, FIFTH",
            "2, true, NONE",
            "2, false, NONE",
            "1, true, NONE",
            "1, false, NONE",
            "0, true, NONE",
            "0, false, NONE",
    })
    void RankFromTest(int input1, boolean input2, Ranking expected) {
        assertThat(Ranking.from(input1, input2)).isEqualTo(expected);
    }
}