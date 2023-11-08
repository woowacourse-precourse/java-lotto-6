package lotto.validator;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.internal.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator;
import org.junit.jupiter.api.Test;

import lotto.error.LottoErrorMessage;

public class ValidatorLottoBuyTest {
    private static final String ERROR_STRING = "[ERROR]";
    private static final 

    @Test
    void 입력값이_숫자인지_검증_성공하면_예외_미발생() {
        // given
        String givenMoney = "123456";

        // when
        assertThatCode(() -> ValidatorLottoBuy.validateString(givenMoney))
                // then
                .doesNotThrowAnyException();
    }

    @Test
    void 입력값이_숫자가_아니면_예외발생_후_오류_식별이_가능한_메시지_발생() {
        // given
        String givenMoney = "1234thereisnotNumeric";

        // when
        assertThatThrownBy(() -> ValidatorLottoBuy.validateString(givenMoney))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_STRING)
                .hasMessageContaining(LottoErrorMessage.WRONG_LOTTO_PRICE.getMessage());
    }

    @Test
    void 로또_금액단위로_입력될_경우_예외_미발생() {
        // given
        BigDecimal lottoBuyingMoney = BigDecimal.valueOf(4500);
        BigDecimal lottoPrice = BigDecimal.valueOf(1500);

        //when
        assertThatCode(()->ValidatorLottoBuy.validateNumber(lottoBuyingMoney, lottoPrice))
                //then
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_금액단위로_입력되지_않을_경우_예외발생_후_오류_식별이_가능한_메시지_발생() {
        // given
        BigDecimal lottoBuyingMoney = BigDecimal.valueOf(4500);
        BigDecimal lottoPrice = BigDecimal.valueOf(1000);

        //when
        assertThatThrownBy(()->ValidatorLottoBuy.validateNumber(lottoBuyingMoney, lottoPrice))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_STRING)
                .hasMessageContaining(LottoErrorMessage.BUYING_PRICE_MUST_PRICE_UNIT.getMessage());
    }

    @Test
    void 로또_가격단위_이하인_가격이_입력될_경우_예외발생_후_오류_식별이_가능한_메시지_발생(){
        // given
        BigDecimal lottoBuyingMoney = BigDecimal.valueOf(0);
        BigDecimal lottoPrice = BigDecimal.valueOf(1500);

        //when
        assertThatThrownBy(()->ValidatorLottoBuy.validateNumber(lottoBuyingMoney, lottoPrice))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_STRING)
                .hasMessageContaining(LottoErrorMessage.NOT_ENOUGH_MONEY.getMessage());
    }
}
