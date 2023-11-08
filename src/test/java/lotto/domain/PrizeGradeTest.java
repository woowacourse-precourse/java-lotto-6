package lotto.domain;

import lotto.domain.PrizeGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeGradeTest {
    @DisplayName("로또 당첨 등급을 알맞게 리턴한다.")
    @Test
    void testPrizeGradeReturn1() {
        PrizeGrade result = PrizeGrade.of(5, true);
        PrizeGrade answer = PrizeGrade.SECOND;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("로또 당첨 등급을 알맞게 리턴한다.")
    @Test
    void testPrizeGradeReturn2() {
        PrizeGrade result = PrizeGrade.of(5, false);
        PrizeGrade answer = PrizeGrade.THIRD;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("로또 당첨 등급을 알맞게 리턴한다.")
    @Test
    void testPrizeGradeReturn3() {
        PrizeGrade result = PrizeGrade.of(3, true);
        PrizeGrade answer = PrizeGrade.FIFTH;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("로또 당첨 등급을 알맞게 리턴한다.")
    @Test
    void testPrizeGradeReturn4() {
        PrizeGrade result = PrizeGrade.of(2, true);
        PrizeGrade answer = PrizeGrade.NO_PRIZE;

        assertThat(result).isEqualTo(answer);
    }
}