package lotto.validator;

import static lotto.validator.PurchasePriceValidator.indivisibleUnit;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PurchasePriceValidatorTest {
    @ParameterizedTest
    @MethodSource
    void 로또의_값으로_나눠지지_않을때_예외처리(int input) {
        //given

        //when
        Throwable result = catchThrowable(() -> indivisibleUnit(input));
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 로또의_값으로_나눠지지_않을때_예외처리() {
        return Stream.of(
                Arguments.of(100),
                Arguments.of(50),
                Arguments.of(0)
        );
    }

}
