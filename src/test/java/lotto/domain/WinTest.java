package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.number.Lotto;
import lotto.domain.number.Win;
import lotto.domain.result.Grade;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinTest {

    @MethodSource("lottoGradeProvider")
    @ParameterizedTest
    void 당첨_숫자와_로또_번호를_비교하여_등수를_반환한다(Lotto lotto, Grade expected) {
        //Arrange
        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Win win = new Win(winNumbers, bonusNumber);

        //Act
        Grade actual = win.match(lotto);

        //Assert
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> lottoGradeProvider() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Grade.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Grade.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Grade.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)), Grade.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)), Grade.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 8, 9, 10, 11)), Grade.NONE)
        );
    }
}