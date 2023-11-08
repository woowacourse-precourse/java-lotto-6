package lotto;

import java.util.stream.Stream;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.util.List.*;
import static lotto.exception.ErrorMessage.NUMBER_DUPLICATE;
import static lotto.exception.ErrorMessage.NUMBER_MISS;
import static lotto.exception.ErrorMessage.SIZE_MISS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @ParameterizedTest
    @MethodSource("lottoNumbersAndRank")
    void testLottoException(List<Integer> list, String message) {
        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(message);
    }

    @DisplayName("같은 번호 수 만큼 개수 반환한다.")
    @Test
    void testCountSameNumber() {
        //given
        Lotto lotto = new Lotto(of(1, 2, 3, 4, 5, 10));
        Lotto answer = new Lotto(of(1, 32, 33, 34, 5, 10));

        //when
        Integer count = lotto.countSameNumber(answer);

        //then
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("보너스 번호 포함시 true 반환.")
    @Test
    void testBonusNumber() {
        Lotto lotto = new Lotto(of(1, 2, 3, 4, 5, 10));

        Integer bonus = 4;

        assertThat(lotto.hasBonusNumber(bonus)).isEqualTo(true);
    }

    static Stream<Arguments> lottoNumbersAndRank() {
        return Stream.of(
                Arguments.arguments(of(1, 2, 3, 4, 5, 6, 7), SIZE_MISS.getMessage()),
                Arguments.arguments(of(1, 2, 3, 4, 5, 5), NUMBER_DUPLICATE.getMessage()),
                Arguments.arguments(of(1, 2, 3, 4, 5, 90), NUMBER_MISS.getMessage())
        );
    }
}