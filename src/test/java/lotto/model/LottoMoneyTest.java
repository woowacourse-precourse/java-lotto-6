package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.CanNotConvertToNumberException;
import lotto.exception.InvalidMoneyException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LottoMoneyTest {


    @Test
    void 돈을_숫자로_바꿀_수_없으면_예외가_발생한다() {
        // given
        String money = "일억";

        // when &then
        assertThatThrownBy(() -> LottoMoney.createWith(money))
                .isInstanceOf(CanNotConvertToNumberException.class);
    }

    @CsvSource({"999", "1999"})
    @ParameterizedTest
    void 돈이_천원보다_작거나_천원으로_나누어지지_않으면_예외가_발생한다(String money) {
        // when & then
        assertThatThrownBy(() -> LottoMoney.createWith(money))
                .isInstanceOf(InvalidMoneyException.class);
    }

    @Test
    void 구매한_로또의_수를_계산한다() {
        // given
        String lottoMoney = "10000";
        LottoMoney money = LottoMoney.createWith(lottoMoney);

        // when
        long count = money.calculateTicketCount();

        // then
        assertThat(count).isEqualTo(10);
    }

    @Test
    void 총_수익률을_계산한다() {
        //given
        long totalPrize = 20000;
        String lottoMoney = "10000";
        LottoMoney money = LottoMoney.createWith(lottoMoney);

        // when
        double totalProfit = money.calculateProfit(totalPrize);

        // then
        assertThat(totalProfit).isEqualTo(200.0);
    }
}
