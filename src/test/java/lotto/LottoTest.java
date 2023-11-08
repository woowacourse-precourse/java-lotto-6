package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    private static String[] winningEx = {"1", "2", "12", "12", "4", "9"};

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

    @DisplayName("당첨번호가 1~45의 숫자가 아니면 예외를 발생시킨다.")
    @Test
    void createRangeOutNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 0, 4, 55, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 중복이 있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("stringArraysProvider")
    void createDuplicateWinningNumber(String[] ex) {
        assertThatThrownBy(() -> new Lotto(ex))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> stringArraysProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "5", "5", "7", "6"}),
                Arguments.of((Object) new String[]{"21", "21", "21", "1", "5", "7"}),
                Arguments.of((Object) new String[]{"12", "15", "4", "12", "4", "1"})
        );

    }
}