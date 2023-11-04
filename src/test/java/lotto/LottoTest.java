package lotto;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.message.LottoGameErrorMessage.NUMBERS_ARE_DUPLICATED;
import static lotto.message.LottoGameErrorMessage.NUMBERS_NOT_IN_RANGE;
import static lotto.message.LottoGameErrorMessage.SIZE_IS_NOT_EXACT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
        exception.hasMessage(SIZE_IS_NOT_EXACT.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
        exception.hasMessage(NUMBERS_ARE_DUPLICATED.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중에 범위 안에 없는 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotRangedNumber() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)));
        exception.hasMessage(NUMBERS_NOT_IN_RANGE.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getLottoNumbersAsFormat_test() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        String result = lotto.getLottoNumbersAsFormat();

        // then
        assertEquals(result, "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void isListSizeExact_exact_true() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertTrue(Lotto.isListSizeExact(numbers));
    }

    @Test
    void isListSizeExact_notExact_false() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertFalse(Lotto.isListSizeExact(numbers));
    }

    @Test
    void isNumbersUnique_unique_true() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertTrue(Lotto.isNumbersUnique(numbers));
    }

    @Test
    void isNumbersUnique_duplicated_false() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 4);

        // when & then
        assertFalse(Lotto.isNumbersUnique(numbers));
    }

    @Test
    void isNumbersInRange_ranged_true() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertTrue(Lotto.isNumbersInRange(numbers));
    }

    @Test
    void isNumbersInRange_notRanged_false() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 46);

        // when & then
        assertFalse(Lotto.isNumbersInRange(numbers));
    }
}