package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Prize.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("당첨 내역 계산")
class PrizesTest {

    @DisplayName("수익률 계산 성공 테스트")
    @ParameterizedTest()
    @MethodSource("calculateBenefitSuccessDummy")
    void calculateBenefitSuccessTest(Prizes prizes, Integer totalSpendAmount, Double expected) {
        Double result = prizes.getRoundedTotalBenefit(totalSpendAmount);
        assertEquals(expected, result);
    }



    static Stream<Arguments> calculateBenefitSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        new Prizes(
                                List.of(FIFTH_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE)
                        ),
                        8000,
                        62.5
                ),
                Arguments.arguments(
                        new Prizes(
                                List.of(FIFTH_PLACE, FIFTH_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE)
                        ),
                        8000,
                        125.0
                ),
                Arguments.arguments(
                        new Prizes(
                                List.of(FIRST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE)
                        ),
                        8000,
                        25000000.0
                )
        );
    }
}