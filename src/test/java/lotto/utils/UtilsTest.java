package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class UtilsTest {
    @DisplayName("돈 형식 테스트")
    @ParameterizedTest
    @MethodSource("provideFormattedMoney")
    public void testFormattedMoney(int money, String expectedFormattedMoney) {
        String formattedMoney = Utils.getFormattedMoney(money);
        assertThat(formattedMoney).isEqualTo(expectedFormattedMoney);
    }

    @DisplayName("퍼센테이지 테스트")
    @ParameterizedTest
    @CsvSource({
            "30, 100, 30.0%",
            "45, 160, 28.13%"
    })
    public void testPercentage(int a, int b, String expectedPercentage) {
        String percentage = Utils.getPercentage(a, b);
        assertThat(percentage).isEqualTo(expectedPercentage);
    }


    static Stream<Arguments> provideFormattedMoney() {
        return Stream.of(
                Arguments.of(1000, "1,000"),
                Arguments.of(10000, "10,000")
        );
    }

}