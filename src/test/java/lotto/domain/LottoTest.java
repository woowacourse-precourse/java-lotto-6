package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoTest {
    private Lotto testLotto;

    @BeforeEach
    void beforeEach() {
        testLotto = null;
    }

    @Test
    void 로또를_정상적으로_생성한다() {
        // Given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        // When
        testLotto = new Lotto(lottoNumbers);
        String expectedNumbers = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        String testLottoNumbers = testLotto.getNumberList().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        // Then
        assertThat(testLottoNumbers).isEqualTo(expectedNumbers);

    }

    @Nested
    class 예외_테스트 {
        @ParameterizedTest(name = "숫자 {0}을 포함하는 로또를 생성하면 예외가 발생한다.")
        @MethodSource("provideInvalidRangeLottoNumber")
        void 숫자_범위_예외(List<Integer> lottoNumbers) {
            assertThatThrownBy(() -> testLotto = new Lotto(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "번호 {0}개의 로또를 생성하면 예외가 발생한다.")
        @MethodSource("provideInvalidCountLottoNumber")
        void 숫자_개수_예외(List<Integer> lottoNumbers) {
            assertThatThrownBy(() -> testLotto = new Lotto(lottoNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("2개의 중복된 숫자를 입력하면 예외가 발생한다.")
        void 중복_숫자_예외() {
            // Given
            List<Integer> lottoNumbers = List.of(1, 1, 2, 3, 4, 5);

            // When
            assertThatThrownBy(() -> testLotto = new Lotto(lottoNumbers))
                    // Then
                    .isInstanceOf(IllegalArgumentException.class);
        }

        private static Stream<Arguments> provideInvalidRangeLottoNumber() {
            return Stream.of(
                    arguments(named("0", List.of(0, 2, 3, 4, 5, 6))),
                    arguments(named("46", List.of(1, 2, 3, 4, 5, 46)))
            );
        }

        private static Stream<Arguments> provideInvalidCountLottoNumber() {
            return Stream.of(
                    arguments(named("0", List.of())),
                    arguments(named("7", List.of(1, 2, 3, 4, 5, 6, 7)))
            );
        }

    }

}
