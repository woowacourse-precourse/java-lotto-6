package lotto.model;

import lotto.config.LottoConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("로또 객체 생성 테스트")
    class LottoCreationTests {

        @Test
        @DisplayName("정상적인 로또 번호 생성")
        void createLottoWithValidNumbers() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(numbers);
            Assertions.assertThat(lotto.getNumbers()).containsExactlyElementsOf(numbers);
        }

        @Test
        @DisplayName("잘못된 개수의 로또 번호로 로또 생성 시 예외 발생")
        void createLottoWithInvalidNumberOfNumbers() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); // Only 5 numbers
            Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Lotto(numbers))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("빈 로또 번호 리스트로 로또 생성 시 예외 발생")
        void createLottoWithEmptyNumbers() {
            List<Integer> numbers = Collections.emptyList(); // Empty list
            Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Lotto(numbers))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("범위를 벗어나는 로또 번호로 로또 생성 시 예외 발생")
        void createLottoWithNumbersOutOfRange() {
            List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 45);
            Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Lotto(numbers))
                    .withMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("값 기반 테스트")
    class ValueBasedTests {

        @ParameterizedTest
        @MethodSource("provideBoundaryValues")
        @DisplayName("경계 값으로 로또 번호 생성")
        void createLottoWithBoundaryNumbers(int boundary) {
            int endValue = (boundary == LottoConfig.START_OF_LOTTO_NUMBER.getValue()) ?
                    boundary + LottoConfig.LOTTO_NUMBER_COUNT.getValue() - 1 :
                    LottoConfig.END_OF_LOTTO_NUMBER.getValue();

            List<Integer> numbers = IntStream
                    .rangeClosed(boundary, endValue)
                    .boxed().collect(Collectors.toList());
            Assertions.assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
        }

        static IntStream provideBoundaryValues() {
            return IntStream.of(LottoConfig.START_OF_LOTTO_NUMBER.getValue(),
                    LottoConfig.END_OF_LOTTO_NUMBER.getValue() - LottoConfig.LOTTO_NUMBER_COUNT.getValue() + 1);
        }

        @Test
        @DisplayName("로또 번호가 너무 많은 경우")
        void whenTooManyNumbersThenThrowException() {
            List<Integer> numbers = IntStream.rangeClosed(1, 7)
                    .boxed().collect(Collectors.toList());
            Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

        // 파라미터화 테스트
        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 4, 5, 6",
                "10, 20, 30, 40, 41, 42",
                "8, 18, 28, 38, 39, 40"
        })
        @DisplayName("여러 유효한 로또 번호 시험")
        void testVariousValidLottoNumbers(int n1, int n2, int n3, int n4, int n5, int n6) {
            List<Integer> numbers = Arrays.asList(n1, n2, n3, n4, n5, n6);
            Assertions.assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("구조 기반 테스트")
    class StructuralBasedTests {

        @Test
        @DisplayName("로또 번호의 유효한 조합")
        void validCombinationOfLottoNumbers() {
            List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11, 13);
            Lotto lotto = new Lotto(numbers);
            Assertions.assertThat(lotto.getNumbers()).hasSize(LottoConfig.LOTTO_NUMBER_COUNT.getValue())
                    .doesNotHaveDuplicates()
                    .allMatch(num -> num >= LottoConfig.START_OF_LOTTO_NUMBER.getValue()
                            && num <= LottoConfig.END_OF_LOTTO_NUMBER.getValue());
        }
    }

    @Nested
    @DisplayName("비 기능적 테스트")
    class NonFunctionalTests {
        @Test
        @DisplayName("다수의 로또 번호 리스트 생성")
        void createMultipleLottoNumberLists() {
            Assertions.assertThatCode(() -> {
                for (int i = 0; i < 10000; i++) {
                    List<Integer> numbers = IntStream.rangeClosed(1, LottoConfig.LOTTO_NUMBER_COUNT.getValue())
                            .boxed().collect(Collectors.toList());
                    new Lotto(numbers);
                }
            }).doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("상태 기반 및 프로퍼티 기반 테스트")
    class StateAndPropertyBasedTests {
        // 프로퍼티 기반 테스트
        @Test
        @DisplayName("로또 번호의 속성 검증")
        void lottoNumberProperties() {
            List<Integer> numbers = Arrays.asList(8, 12, 19, 27, 34, 42);
            Lotto lotto = new Lotto(numbers);
            Assertions.assertThat(lotto.getNumbers())
                    .hasSize(LottoConfig.LOTTO_NUMBER_COUNT.getValue())
                    .doesNotHaveDuplicates()
                    .allMatch(num -> num >= LottoConfig.START_OF_LOTTO_NUMBER.getValue()
                            && num <= LottoConfig.END_OF_LOTTO_NUMBER.getValue());
        }

        // 상태 기반 테스트
        @Test
        @DisplayName("로또 객체의 상태 검증")
        void verifyLottoObjectState() {
            List<Integer> numbers = Arrays.asList(3, 6, 9, 12, 15, 18);
            Lotto lotto = new Lotto(numbers);
            Assertions.assertThat(lotto.getNumbers())
                    .hasSize(LottoConfig.LOTTO_NUMBER_COUNT.getValue())
                    .doesNotHaveDuplicates()
                    .isSorted();
        }
    }

    @Nested
    @DisplayName("Lotto 동등성 테스트")
    class LottosEqualityTests {

        @Test
        @DisplayName("동일한 Lotto 인스턴스 비교 - equals & hashCode")
        void testLottoEquality() {
            // 준비
            Lotto lottoOne = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            Lotto lottoTwo = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

            // 실행 & 검증
            assertThat(lottoOne).isEqualTo(lottoTwo);
            assertThat(lottoOne.hashCode()).isEqualTo(lottoTwo.hashCode());
        }

        @Test
        @DisplayName("동일하지 않은 Lotto 인스턴스 비교 - equals & hashCode")
        void testLottoInequality() {
            // 준비
            Lotto lottoOne = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            Lotto lottoTwo = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));

            // 실행 & 검증
            assertThat(lottoOne).isNotEqualTo(lottoTwo);
            assertThat(lottoOne.hashCode()).isNotEqualTo(lottoTwo.hashCode());
        }

        @Test
        @DisplayName("동일한 Lotto 인스턴스 비교 - equals & hashCode")
        void testSameInstanceEquality() {
            // 준비
            Lotto lottoOne = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

            // 실행 & 검증
            assertThat(lottoOne).isEqualTo(lottoOne); // 자기 자신과의 비교
            assertThat(lottoOne.hashCode()).isEqualTo(lottoOne.hashCode());
        }

        @Test
        @DisplayName("Lotto와 null 비교")
        void testLottoWithNull() {
            // 준비
            Lotto lottoOne = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

            // 실행 & 검증
            assertThat(lottoOne).isNotEqualTo(null); // null과 비교
        }

        @Test
        @DisplayName("다른 클래스의 인스턴스와 Lotto 비교")
        void testLottoWithDifferentClass() {
            // 준비
            Lotto lottoOne = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
            Object differentObject = new Object();

            // 실행 & 검증
            assertThat(lottoOne).isNotEqualTo(differentObject); // 다른 타입과의 비교
        }
    }
}