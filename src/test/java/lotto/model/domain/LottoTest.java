package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.result.compare.LottoCompareResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @ParameterizedTest
    @MethodSource("wrongRangeList")
    @DisplayName("범위에 벗어나는 값이 포함되어 있으면 예외가 발생한다.")
    void 범위에_벗어나는_값이_포함되어_있으면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> wrongRangeList() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @ParameterizedTest
    @MethodSource("equalsArgs")
    void 로또_동등성_테스트(Lotto l1, Lotto l2, LottoCompareResult result) {
        Assertions.assertThat(l1.compareLotto(l2))
                .isEqualTo(result);
    }

    static Stream<Arguments> equalsArgs() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoCompareResult(6)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                        new LottoCompareResult(5)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new LottoCompareResult(0)),

                Arguments.of(new Lotto(List.of(1, 3, 6, 15, 19, 31)),
                        new Lotto(List.of(6, 11, 19, 23, 31, 42)),
                        new LottoCompareResult(3))
        );
    }
}