package lotto;

import static lotto.message.LottoGameErrorMessage.BASE_UNIT_INPUT_MESSAGE;
import static lotto.message.LottoGameErrorMessage.NOT_ABLE_TO_PARSE_INT_MESSAGE;
import static lotto.message.LottoGameErrorMessage.UNDER_ZERO_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {

    @Test
    public void isAbleToParseInteger_number_true() {
        // given
        String input = "123";

        // when
        boolean result = LottoMoney.isAbleToParseInteger(input);

        // then
        assertTrue(result);
    }

    @Test
    public void isAbleToParseInteger_text_false() {
        // given
        String input = "12a";

        // when
        boolean result = LottoMoney.isAbleToParseInteger(input);

        // then
        assertFalse(result);
    }

    @Test
    public void isOverZero_over_true() {
        // given
        int input = 1;

        // when
        boolean result = LottoMoney.isOverZero(input);

        // then
        assertTrue(result);
    }

    @Test
    public void isOverZero_under_false() {
        // given
        int input = 0;

        // when
        boolean result = LottoMoney.isOverZero(input);

        // then
        assertFalse(result);
    }

    @Test
    public void isBaseMoneyUnit_notUnit() {
        // given
        int input = 1;

        // when
        boolean result = LottoMoney.isBaseMoneyUnit(input);

        // then
        assertFalse(result);
    }

    @Test
    public void isBaseMoneyUnit_isUnit() {
        // given
        int input = 1000;

        // when
        boolean result = LottoMoney.isBaseMoneyUnit(input);

        // then
        assertTrue(result);
    }

    @Test
    public void validate_not_able_to_parse_int() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new LottoMoney("a"));
        exception.hasMessage(NOT_ABLE_TO_PARSE_INT_MESSAGE.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validate_under_zero() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new LottoMoney("0"));
        exception.hasMessage(UNDER_ZERO_MESSAGE.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validate_not_base_unit() {
        AbstractThrowableAssert<?, ? extends Throwable> exception =
                assertThatThrownBy(() -> new LottoMoney("1"));
        exception.hasMessage(BASE_UNIT_INPUT_MESSAGE.getMessage());
        exception.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getCountForBuyingLotto_test() {
        // given
        LottoMoney lottoMoney = new LottoMoney("8000");

        // when
        int result = lottoMoney.getCountForBuyingLotto();

        // then
        assertEquals(result, 8);
    }

    @Test
    public void calculateProfit() {
        // given
        LottoMoney lottoMoney = new LottoMoney("8000");

        // when
        double result = lottoMoney.calculateProfitPercentage(5000);

        // then
        assertEquals(result, 62.5);
    }
}