package lotto;

import java.util.stream.IntStream;
import lotto.message.BonusNumber;
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.message.LottoGameErrorMessage.NOT_ABLE_TO_PARSE_INT_MESSAGE;
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
    void constructor_string_input() {
        // given
        String text = "1,2,3,4,5,6";

        // when
        Lotto lotto = new Lotto(text);
        String result = lotto.getLottoNumbersAsFormat();

        // then
        assertEquals(result, "[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void constructor_notInteger_throw_exception() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new Lotto("a, 2, 3, 4, 5, 6"));
        exception.hasMessage(NOT_ABLE_TO_PARSE_INT_MESSAGE.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertInputAsIntegerListThrowTest() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> Lotto.convertInputAsIntegerList("1,2,a"));
        exception.hasMessage(NOT_ABLE_TO_PARSE_INT_MESSAGE.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void convertInputAsIntegerListTest() {
        // given
        String text = "1,2,3,4,5,6";

        // when
        List<Integer> numbers = Lotto.convertInputAsIntegerList(text);

        // then
        IntStream.rangeClosed(1, 6).forEach(i -> assertTrue(numbers.contains(i)));
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

    @Test
    public void countDuplicateTest() {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        Lotto winLotto = new Lotto("4,5,6,7,8,9");

        // when
        int result = lotto.countDuplicate(winLotto);

        // then
        assertEquals(result, 3);
    }

    @Test
    public void hasNumber_has() {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        // when
        boolean result = lotto.hasNumber(1);

        // then
        assertTrue(result);
    }

    @Test
    public void hasNumber_notIncluded() {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        // when
        boolean result = lotto.hasNumber(7);

        // then
        assertFalse(result);
    }

    @Test
    public void calculateBonus() {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        BonusNumber bonus = new BonusNumber("1");

        // when
        boolean result = lotto.calculateBonus(5, bonus);

        // then
        assertTrue(result);
    }
}