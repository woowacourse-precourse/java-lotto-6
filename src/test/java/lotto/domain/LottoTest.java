package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(Lifecycle.PER_CLASS)
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
        String expectedNumbers = "1,2,3,4,5,6";

        // Then
        assertThat(testLotto.getNumber()).isEqualTo(expectedNumbers);

    }

    @ParameterizedTest(name = "번호 {0}개의 로또를 생성하면 예외가 발생한다.")
    @MethodSource("provideInvalidLottoNumber")
    void 예외_테스트(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> testLotto = new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Stream<Arguments> provideInvalidLottoNumber() {
        return Stream.of(
                arguments(named("0", List.of())),
                arguments(named("7", List.of(1, 2, 3, 4, 5, 6, 7)))
        );
    }
}
