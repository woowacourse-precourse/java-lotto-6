package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {
    @DisplayName("일치하는 개수와 보너스 번호 일치 여부로 등수를 반환한다.")
    @ParameterizedTest
    @CsvSource({
        "6,false,FIRST",
        "5,true,SECOND",
        "5,false,THIRD",
        "4,false,FOURTH",
        "3,false,FIFTH",
        "0,false,NONE"})
    void valueOf(int matchedCount, boolean isBonus, Prize result) {
        Prize actual = Prize.valueOf(matchedCount, isBonus);

        assertThat(actual).isEqualTo(result);
    }
}
