package lotto;

import lotto.dto.Lotto;
import lotto.view.InputBonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("랜덤으로 부여된 로또에 1~45 사이가 아닌 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("getOutOfRangeNum")
    void checkOutOfRangeNum(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> getOutOfRangeNum() {
        return Stream.of(
                Arguments.of(List.of(-27, 324, 7, 12, 9, 70)),
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(10, 11, 12, 13, 14, 46))
        );
    }

    @DisplayName("로또번호가 오름차순으로 정렬되는지 확인한다.")
    @Test
    void checkLottoNumArray() {
        List<Integer> input = List.of(10, 9, 8, 7, 6, 5);
        List<Integer> expectedOutput = List.of(5, 6, 7, 8, 9, 10);

        Lotto lotto = new Lotto(input);
        assertThat(lotto.toString()).isEqualTo(expectedOutput.toString());
    }

}