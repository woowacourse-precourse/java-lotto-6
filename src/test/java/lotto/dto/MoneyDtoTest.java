package lotto.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyDtoTest {
    private static final int SINGLE_LOTTO_PRICE = 1000;
    private static final String ERROR_CODE = "[ERROR]";

    @Test
    void MoneyDto는_금액을_포함하는_객체다() {
        int amount = 1000;
        MoneyDto moneyDto = new MoneyDto(amount);

        assertThat(moneyDto.amount())
                .isEqualTo(1000);
    }

    @Test
    void 음수의_금액을_입력하려고하면_IllegalArgumentException_예외_발생() {
        int minus = -1;

        assertThatThrownBy(() -> new MoneyDto(minus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_한장_가격으로_나누어떨어지지_않는_금액도_IllegalArgumentException_예외_발생() {
        int lessThanSingleLottoPrice = SINGLE_LOTTO_PRICE - 100;
        int notDividedBySingleLottoPrice = SINGLE_LOTTO_PRICE + 100;

        assertThatThrownBy(() -> new MoneyDto(lessThanSingleLottoPrice))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MoneyDto(notDividedBySingleLottoPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력이나_로또_한장_가격으로_나누어떨어지지_않는_예외시_에러코드를_메시지에_포함() {
        int minus = -1;
        int lessThanSingleLottoPrice = SINGLE_LOTTO_PRICE - 100;
        int notDividedBySingleLottoPrice = SINGLE_LOTTO_PRICE + 100;

        assertThatThrownBy(() -> new MoneyDto(minus))
                .hasMessageContaining(ERROR_CODE);
        assertThatThrownBy(() -> new MoneyDto(lessThanSingleLottoPrice))
                .hasMessageContaining(ERROR_CODE);
        assertThatThrownBy(() -> new MoneyDto(notDividedBySingleLottoPrice))
                .hasMessageContaining(ERROR_CODE);
    }
}