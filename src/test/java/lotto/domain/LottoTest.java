package lotto.domain;

import java.util.Collections;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class LottoTest {
    static List<List<Integer>> provideLottoNumbersInvalidLength() {
        return List.of(
                Collections.emptyList(),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbersInvalidLength")
    void 로또_번호의_개수가_6개가_아니라면_예외를_발생시킨다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    static List<List<Integer>> provideDuplicateLottoNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 5),
                List.of(1, 1, 1, 1, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateLottoNumbers")
    void 로또_번호에_중복된_숫자가_있다면_예외를_발생시킨다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static List<List<Integer>> provideValidLottoNumbers() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(45, 44, 43, 42, 41, 40)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidLottoNumbers")
    void 올바른_로또_번호로_로또를_생성할_수_있다(List<Integer> numbers) {
        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }
}
