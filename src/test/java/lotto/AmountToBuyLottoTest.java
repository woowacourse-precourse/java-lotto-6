package lotto;

import static lotto.Constants.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AmountToBuyLottoTest {

    public static final String MONEY = "1000";

    @Test
    void 구입금액_만드는_기능() {
        // given
        AmountToBuyLotto amountToBuyLotto = AmountToBuyLotto.newInstance(MONEY);
        // when

        // then
        assertThat(amountToBuyLotto).isInstanceOf(AmountToBuyLotto.class);
    }

    @Test
    void 구입금액_확인_기능() {
        // given
        AmountToBuyLotto amountToBuyLotto = AmountToBuyLotto.newInstance(MONEY);
        // when
        Integer amount = amountToBuyLotto.getAmount();
        // then
        assertThat(amount).isEqualTo(Integer.parseInt(MONEY));
    }

    @Test
    void 구입금액을_1000원_단위로_나누는_기능() {
        // given
        AmountToBuyLotto amountToBuyLotto = AmountToBuyLotto.newInstance(MONEY);
        // when
        int value = amountToBuyLotto.dividedByLottoPrice();
        // then
        assertThat(value).isEqualTo(amountToBuyLotto.getAmount() / LOTTO_PRICE);
    }

    @Test
    void 공백이면_예외발생() {
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance(" ")).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 빈칸이면_예외발생() {
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("")).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아니면_예외발생() {
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("a")).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("a11")).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("**1")).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("1,,")).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 숫자_사이에_공백이면_예외발생() {
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("100 00")).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 구입금액_범위에_벗어나면_예외발생() {
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("-1000")).isInstanceOf(
            IllegalArgumentException.class);
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("2000001000")).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_0이면_예외발생() {
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("0")).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_천원단위로_안나뉘면_예외발생() {
        assertThatThrownBy(() -> AmountToBuyLotto.newInstance("1003")).isInstanceOf(
            IllegalArgumentException.class);
    }


    @Test
    void dividedByLottoPrice() {
    }
}