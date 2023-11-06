package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InvalidMoneyRangeException;
import lotto.exception.NonPositiveIntException;
import lotto.fixture.MoneyFixture;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class MoneyTest {

    @CsvSource({"1500", "0"})
    @ParameterizedTest
    void 유효하지_않은_금액을_입력하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> Money.from(input))
                .isInstanceOf(InvalidMoneyRangeException.class);
    }

    @CsvSource({"abc", "1000a"})
    @ParameterizedTest
    void 숫자가_아닌_문자열을_입력하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> Money.from(input))
                .isInstanceOf(NonPositiveIntException.class);
    }

    @Test
    void 로또_구매_가능한_개수를_반환한다() {
        // given
        Money money = MoneyFixture.create("5000");

        // when
        long buyLottoCount = money.buyLotto();

        // then
        assertThat(buyLottoCount).isEqualTo(5);
    }

    @Test
    void 수익률을_계산해서_반환한다() {
        // given
        Money money = MoneyFixture.create("5000");
        long sumOfPrice = 10000;

        // when
        double returnRate = money.calculateReturnRate(sumOfPrice);

        // then
        assertThat(returnRate).isEqualTo(200);
    }
}
