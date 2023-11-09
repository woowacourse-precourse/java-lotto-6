package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.util.ErrorMessage;
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

    @DisplayName("로또번호가 1~45 범위에 있지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("outRangedNumber")
    void createLottoByOutRanged(List<Integer> numberList, String error) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2,3,4,5,56)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(error)
        ;
    }

    public static Stream<Arguments> outRangedNumber() {
        return Stream.of(
                Arguments.arguments(List.of(0,2,3,4,5,6),ErrorMessage.INVALID_NUMBER_RANGE),
                Arguments.arguments(List.of(2,3,4,5,6,56),ErrorMessage.INVALID_NUMBER_RANGE)
        );
    }

}