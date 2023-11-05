package lotto.model.domain;

import java.util.stream.Stream;
import lotto.model.domain.Lotto;
import lotto.model.domain.result.CompareResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void wrongRangeNumber(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> wrongRangeList(){
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @ParameterizedTest
    @MethodSource("toStringTestArgs")
    public void 정해진_포맷으로_숫자가_정렬되어_출력(List<Integer> lottoNumbers, String lottoString) throws Exception{
        //given
        Lotto lotto = new Lotto(lottoNumbers);

        //when
        //then
        Assertions.assertThat(lotto.toString())
                .isEqualTo(lottoString);
    }

    private static Stream<Arguments> toStringTestArgs(){
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "[1, 2, 3, 4, 5, 6]"),
                Arguments.of(List.of(1, 5, 12, 15, 21, 25), "[1, 5, 12, 15, 21, 25]"),
                Arguments.of(List.of(12, 15, 20, 25, 31, 42), "[12, 15, 20, 25, 31, 42]"),
                Arguments.of(List.of(12, 4, 7, 3, 1, 5), "[1, 3, 4, 5, 7, 12]")
        );
    }

    @ParameterizedTest
    @MethodSource("equalsArgs")
    void 로또_동등성_테스트(Lotto l1, Lotto l2, CompareResult result){
        Assertions.assertThat(l1.compareLotto(l2))
                .isEqualTo(result);
    }

    static Stream<Arguments> equalsArgs(){
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new CompareResult(6, false)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                        new CompareResult(5, false)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                        new CompareResult(0, false)),

                Arguments.of(new Lotto(List.of(1, 3, 6, 15, 19, 31)),
                        new Lotto(List.of(6, 11, 19, 23, 31, 42)),
                        new CompareResult(3, false))
        );
    }

    @ParameterizedTest
    @MethodSource("equalsWithAnswerArgs")
    void 정답과_동등성_테스트(Lotto l1, Lotto l2, CompareResult result){
        Assertions.assertThat(l1.compareLotto(l2))
                .isEqualTo(result);
    }

    static Stream<Arguments> equalsWithAnswerArgs(){
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 9),
                        new CompareResult(6, false)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(2, 3, 4, 5, 6, 7), 10),
                        new CompareResult(5, false)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(2, 3, 4, 5, 6, 7), 1),
                        new CompareResult(5, true)),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(7, 8, 9, 10, 11, 12), 6),
                        new CompareResult(0, false)),

                Arguments.of(new Lotto(List.of(1, 3, 6, 15, 19, 31)),
                        new LottoAnswer(List.of(6, 11, 19, 23, 31, 42), 1),
                        new CompareResult(3, false))
        );
    }
}