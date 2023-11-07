package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCalculationServiceTest {
    private LuckyNumbers luckyNumbers;

    @BeforeEach
    void setup() {
        luckyNumbers = new LuckyNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(7));
    }

    @DisplayName("등수 계산 테스트")
    @ParameterizedTest
    @CsvSource({"6 5 4 3 2 1, FIRST",
                "7 5 4 3 2 1, SECOND",
                "8 5 4 3 2 1, THIRD",
                "9 11 4 3 2 1, FOURTH",
                "10 12 13 3 2 1,FIFTH"})
    void rankCalculation(String input, Rank expectRank) {
        //given
        Lotto lotto = new Lotto(input);

        //when
        Rank rank = WinningCalculationService.calculateRank(lotto,luckyNumbers);

        //then
        assertThat(rank).isEqualTo(expectRank);

    }
}