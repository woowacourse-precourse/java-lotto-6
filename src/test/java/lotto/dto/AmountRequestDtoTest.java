package lotto.dto;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AmountRequestDtoTest {

    @ParameterizedTest
    @DisplayName("구매 금액 입력 전달 DTO 테스트")
    @MethodSource("initAmountRequestDtoData")
    void amountStringToIntegerTest(String inputValue, int amount) {
        AmountRequestDto amountRequestDto = new AmountRequestDto(inputValue);

        Assertions.assertThat(amount).isEqualTo(amountRequestDto.amountStringToInteger());
    }

    static Stream<Arguments> initAmountRequestDtoData() {
        return Stream.of(
                Arguments.of("1000", 1000),
                Arguments.of("20000", 20000),
                Arguments.of("30000", 30000)
        );
    }

}