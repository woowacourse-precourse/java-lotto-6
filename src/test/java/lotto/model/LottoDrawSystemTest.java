package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoDrawSystemTest {

    static LottoDrawSystem drawSystem;

    @BeforeAll
    static void prepare() {
        drawSystem = new LottoDrawSystem();
        drawSystem.setNumbers("1,2,3,4,5,6,7");

    }

    @DisplayName("적절하지 않은 정답 번호들 입력 테스트")
    @ParameterizedTest
    @CsvSource({
            "2,2,3,4,5,6,7",
            "45,46,1,2,3,4",
            "a,b,c,d,e,f,g"
    })
    void testValidateNumbers(String givenNumbers) {
        assertThatThrownBy(() -> drawSystem.validateNumbers(givenNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("맞춘 번호 갯수에 따른 등수 테스트")
    @ParameterizedTest
    @MethodSource("providedNumbersAndGrade")
    void testDrawAndGetGrade(int[] numbers, int expectedGrade) {
        int grade = drawSystem.draw(numbers);
        assertThat(grade).isEqualTo(expectedGrade);
    }

    static Stream<Arguments> providedNumbersAndGrade() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5,6,20}, 1),
                Arguments.of(new int[] {1,2,3,4,5,9,7}, 2),
                Arguments.of(new int[] {1,2,3,4,5,9,20}, 3),
                Arguments.of(new int[] {1,2,3,4,10,9,20}, 4),
                Arguments.of(new int[] {1,2,3,11,10,7}, 4),
                Arguments.of(new int[] {1,2,3,11,10,20}, 5),
                Arguments.of(new int[] {1,2,12,11,10,7}, 5)
        );
    }
}