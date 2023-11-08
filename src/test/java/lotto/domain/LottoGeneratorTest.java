package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import lotto.util.generator.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoGeneratorTest {
    @Nested
    @DisplayName("로또 조건을 만족하는 경우")
    class validatedLotto {
        private Lotto generatedLotto = LottoGenerator.generateLotto(
                () -> Randoms.pickUniqueNumbersInRange(1, 45, 6));
        private List<Integer> lottoNumbers = generatedLotto.getLotto();

        @Test
        void 로또_번호_6개_검증() {
            assertThat(lottoNumbers.size()).isEqualTo(6);
        }

        @Test
        void 중복이_없는지_검증() {
            assertThat(lottoNumbers.size()).isEqualTo(
                    new HashSet<Integer>(lottoNumbers).size());
        }

        @Test
        void 로또_범위가_1에서_45인지_검증() {
            assertThat(
                    lottoNumbers.stream()
                            .filter(number -> number > 45 || number < 1)
                            .findFirst()
                            .isPresent()).isEqualTo(false);
        }
    }

    @Nested
    @DisplayName("로또 조건을 만족하지 못하는 경우")
    class unvalidLotto {
        private static Stream<Arguments> generateWrongSizeLotto() {
            return Stream.of(
                    Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                    Arguments.of(Arrays.asList(1, 2, 3, 4)),
                    Arguments.of(Arrays.asList(1, 2, 3))
            );
        }

        @ParameterizedTest(name = "로또 번호 : {0}")
        @MethodSource("generateWrongSizeLotto")
        void 개수가_6개_아니라면_예외(List<Integer> wrongSizeLotto) {
            assertThatThrownBy(() -> Lotto.from(wrongSizeLotto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("6개의 숫자를");
        }

        private static Stream<Arguments> generateDuplicatedLotto() {
            return Stream.of(
                    Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5)),
                    Arguments.of(Arrays.asList(1, 2, 3, 4, 4, 4)),
                    Arguments.of(Arrays.asList(1, 2, 3, 3, 4, 4))
            );
        }

        @ParameterizedTest(name = "로또 번호 : {0}")
        @MethodSource("generateDuplicatedLotto")
        void 번호가_중복되면_예외(List<Integer> duplicatedLotto) {
            assertThatThrownBy(() -> Lotto.from(duplicatedLotto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("중복된");
        }

        private static Stream<Arguments> generateOutOfRangeLotto() {
            return Stream.of(
                    Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46)),
                    Arguments.of(Arrays.asList(0, 2, 3, 4, 5, 6)),
                    Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 100))
            );
        }

        @ParameterizedTest(name = "로또 번호 : {0}")
        @MethodSource("generateOutOfRangeLotto")
        void 범위에서_벗어나면_예외(List<Integer> outOfRangeLotto) {
            assertThatThrownBy(() -> Lotto.from(outOfRangeLotto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("범위에서 벗어난 수를");
        }
    }
}
