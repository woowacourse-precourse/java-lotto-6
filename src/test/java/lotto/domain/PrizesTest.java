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

    @DisplayName("당첨금 계산 성공 테스트")
    @ParameterizedTest()
    @MethodSource("countTotalPriceSuccessDummy")
    void countTotalPriceSuccessTest(Prizes prizes, Double expected) {
        Double totalPrice = prizes.countTotalPrice();
        assertEquals(expected, totalPrice);
    }




    static Stream<Arguments> countTotalPriceSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        new Prizes(
                                List.of(LAST_PLACE, FIRST_PLACE, SECOND_PLACE, LAST_PLACE, LAST_PLACE)
                        ),
                        230_000_000.0),
                Arguments.arguments(
                        new Prizes(
                                List.of(LAST_PLACE, SECOND_PLACE, LAST_PLACE, SECOND_PLACE)
                        ),
                        60_000_000.0),
                Arguments.arguments(
                        new Prizes(
                                List.of(LAST_PLACE, FIRST_PLACE, SECOND_PLACE, FIRST_PLACE, LAST_PLACE)
                        ),
                        430_000_000.0)
        );
    }

    static Stream<Arguments> calculateBenefitSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        new Prizes(
                                List.of(FIFTH_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE, LAST_PLACE)
                        ),
                        8000,
                        62.5
                )
        );
    }
}