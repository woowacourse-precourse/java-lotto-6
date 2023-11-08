package lotto.model.data;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.record.Money;
import lotto.model.record.NumberOfLotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRecipeTest {

    LottoRecipe lottoRecipe;

    @ParameterizedTest(name = "{0} / 1000 = {1}")
    @CsvSource({
            "1000, 1",
            "10000, 10",
            "2147483000, 2147483"
    })
    void calculateCountOfLottoTest(int money, int expectedCountOfLotto) {
        // given
        lottoRecipe = LottoRecipe.from(new Money(money));

        // when & then
        assertThat(lottoRecipe.purchaseLotto()).isEqualTo(new NumberOfLotto(expectedCountOfLotto));
    }

}