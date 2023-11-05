package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
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


    @ParameterizedTest
    @MethodSource
    void 지정된_6개의_숫자를_오른차순으로_정렬한다(List<Integer> lottoNumbers, List<Integer> expectNumbers) {
        //given
        Lotto lotto = new Lotto(lottoNumbers);
        //when
        List<Integer> resultNumbers = lotto.getNumbers();
        //then
        assertThat(resultNumbers).isEqualTo(expectNumbers);
    }

    private static Stream<Arguments> 지정된_6개의_숫자를_오른차순으로_정렬한다() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1)),
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of(new ArrayList<>(Arrays.asList(45, 35, 25, 15, 5, 1)),
                        new ArrayList<>(Arrays.asList(1, 5, 15, 25, 35, 45))),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 6, 5, 4)),
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of(new ArrayList<>(Arrays.asList(11, 21, 12, 22, 13, 33)),
                        new ArrayList<>(Arrays.asList(11, 12, 13, 21, 22, 33))),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 9, 8, 4, 3)),
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 9)))

        );
    }

    @ParameterizedTest
    @MethodSource
    void 보너스_번호를_포함하는지_확인한다(List<Integer> lottoNumbers, int bonusNumber, boolean expectResult) {
        //given
        Lotto lotto = new Lotto(lottoNumbers);
        //when
        boolean result = lotto.contains(bonusNumber);
        //then
        assertThat(result).isEqualTo(expectResult);
    }

    private static Stream<Arguments> 보너스_번호를_포함하는지_확인한다() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1)),
                        1, true),
                Arguments.of(new ArrayList<>(Arrays.asList(45, 35, 25, 15, 5, 1)),
                        40, false),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 6, 5, 4)),
                        6, true),
                Arguments.of(new ArrayList<>(Arrays.asList(11, 21, 12, 22, 13, 33)),
                        15, false),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 9, 8, 4, 3)),
                        1, true)

        );
    }

    @ParameterizedTest
    @MethodSource
    void 몇개의_로또_번호가_서로_일치하는지_확인한다(List<Integer> lottoNumbers, List<Integer> winningNumbers, int expectResult) {
        //given
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);
        //when
        int result = lotto.findSameCount(winningLotto);
        //then
        assertThat(result).isEqualTo(expectResult);
    }

    private static Stream<Arguments> 몇개의_로또_번호가_서로_일치하는지_확인한다() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1)),
                        new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1)), 6),
                Arguments.of(new ArrayList<>(Arrays.asList(45, 35, 25, 15, 5, 1)),
                        new ArrayList<>(Arrays.asList(3, 4, 25, 15, 5, 1)), 4),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 6, 5, 4)),
                        new ArrayList<>(Arrays.asList(1, 2, 11, 12, 13, 14)), 2),
                Arguments.of(new ArrayList<>(Arrays.asList(11, 21, 12, 22, 13, 33)),
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 0),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 9, 8, 4, 3)),
                        new ArrayList<>(Arrays.asList(1, 11, 12, 13, 14, 15)), 1)

        );
    }

}