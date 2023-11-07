package lotto.dto;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusRequestDtoTest {

    @ParameterizedTest
    @DisplayName("보너스 번호 입력 전달 DTO 테스트")
    @MethodSource("initBonusRequestDtoData")
    void bonusStringToIntegerTest(String inputValue, int bonus) {
        BonusRequestDto bonusRequestDto = new BonusRequestDto(inputValue);

        Assertions.assertThat(bonus).isEqualTo(bonusRequestDto.bonusStringToInteger());
    }

    static Stream<Arguments> initBonusRequestDtoData() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("20", 20),
                Arguments.of("35", 35)
        );
    }

}