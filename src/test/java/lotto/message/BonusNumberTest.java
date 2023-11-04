package lotto.message;

import static lotto.message.LottoGameErrorMessage.NOT_ABLE_TO_PARSE_INT_MESSAGE;
import static lotto.message.LottoGameErrorMessage.NUMBERS_NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    public void isNumberInRange_ranged_true() {
        // given
        int number = 13;

        // when & then
        assertTrue(BonusNumber.isNumberInRange(number));
    }

    @Test
    public void isNumberInRange_notRanged_false() {
        // given
        int number = 50;

        // when & then
        assertFalse(BonusNumber.isNumberInRange(number));
    }

    @Test
    public void isAbleToParseInteger_true() {
        // given
        String input = "13";

        // when & then
        assertTrue(BonusNumber.isAbleToParseInteger(input));
    }

    @Test
    public void isAbleToParseInteger_false() {
        // given
        String input = "1a";

        // when & then
        assertFalse(BonusNumber.isAbleToParseInteger(input));
    }

    @Test
    public void validate_not_able_to_parse_int() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new BonusNumber("a"));
        exception.hasMessage(NOT_ABLE_TO_PARSE_INT_MESSAGE.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validate_not_in_range() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new BonusNumber("50"));
        exception.hasMessage(NUMBERS_NOT_IN_RANGE.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }
}