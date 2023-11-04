package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.Prize.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("당첨 내역 계산")
class PrizesTest {


    static Stream<Arguments> countTotalPriceSuccessDummy() {
        return Stream.of(
                Arguments.arguments(
                        List.of(LAST_PLACE, FIRST_PLACE, SECOND_PLACE, LAST_PLACE, LAST_PLACE),
                        2300000000.0),
                Arguments.arguments(
                        List.of(LAST_PLACE, SECOND_PLACE, LAST_PLACE, SECOND_PLACE),
                        600000000.0),
                Arguments.arguments(
                        List.of(LAST_PLACE, FIRST_PLACE, SECOND_PLACE, FIRST_PLACE, LAST_PLACE),
                        4300000000.0)
                );
    }

}