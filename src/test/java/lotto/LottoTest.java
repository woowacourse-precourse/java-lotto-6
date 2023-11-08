package lotto;

import lotto.exception.ExceptionMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @ParameterizedTest
    @MethodSource("createSuccessTestData")
    @DisplayName("Lotto_객체_생성")
    void createLotto(List<Integer> inputList) {
        assertThat(new Lotto(inputList))
                .isInstanceOf(Lotto.class);
    }

    private static Stream<Arguments> createSuccessTestData() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6)),
                Arguments.of(List.of(7,8,9,10,11,12)),
                Arguments.of(List.of(13,14,15,16,17,18))
        );
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_LOTTO_SIZE.getErrorMessage());
    }

    @DisplayName("로또_번호_중복_예외_발생")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_LOTTO_NUMBER.getErrorMessage());
    }

    @ParameterizedTest
    @MethodSource("notRangeNumberTestData")
    @DisplayName("잘못된_로또_번호_범위_예외")
    void createLottoByNotRangeNumber(List<Integer> inputList) {
        assertThatThrownBy(() -> new Lotto(inputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NUMBER_RANGE.getErrorMessage());
    }

    private static Stream<Arguments> notRangeNumberTestData() {
        return Stream.of(
                Arguments.of(List.of(-1,2,3,4,5,6)),
                Arguments.of(List.of(7,8,9,10,11,46)),
                Arguments.of(List.of(0,14,15,16,17,18))
        );
    }
}