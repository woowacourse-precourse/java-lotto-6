package lotto.model;

import lotto.config.LottoConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

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
    @DisplayName("중복된 로또 번호로 로또 생성 시 예외 발생")
    void createLottoWithDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 4, 5); // Duplicate number 1
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

    // 경계 값 분석 테스트
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
        return IntStream.of(LottoConfig.START_OF_LOTTO_NUMBER.getValue(), LottoConfig.END_OF_LOTTO_NUMBER.getValue() - LottoConfig.LOTTO_NUMBER_COUNT.getValue() + 1);
    }

    // 동치 분할 테스트
    @Test
    @DisplayName("로또 번호가 너무 많은 경우")
    void whenTooManyNumbersThenThrowException() {
        List<Integer> numbers = IntStream.rangeClosed(1, 7)
                .boxed().collect(Collectors.toList());
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    // 조합 테스트
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

    // 부하 테스트 (많은 수의 로또를 생성)
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

    // 프로퍼티 기반 테스트
    @Test
    @DisplayName("로또 번호의 속성 검증")
    void lottoNumberProperties() {
        List<Integer> numbers = Arrays.asList(8, 12, 19, 27, 34, 42);
        Lotto lotto = new Lotto(numbers);
        Assertions.assertThat(lotto.getNumbers())
                .hasSize(LottoConfig.LOTTO_NUMBER_COUNT.getValue())
                .doesNotHaveDuplicates()
                .allMatch(num -> num >= LottoConfig.START_OF_LOTTO_NUMBER.getValue() && num <= LottoConfig.END_OF_LOTTO_NUMBER.getValue());
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