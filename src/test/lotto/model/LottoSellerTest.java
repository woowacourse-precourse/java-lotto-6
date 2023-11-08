package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoSellerTest {
    private LottoNumbersGenerator numbersGenerator;

    @BeforeEach
    void setUp() {
        numbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100, 500, 750, 1250, 1500, 1750, -1000})
    void 로또_판매시_구입_금액이_1000원_단위가_아니면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> LottoSeller.sellLotto(purchaseAmount, numbersGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "10000,10", "15000,15"}, delimiter = ',')
    void 로또_판매시_금액만큼_로또를_발행한다(int purchaseAmount, int count) {
        Lottos lottos = LottoSeller.sellLotto(purchaseAmount, numbersGenerator);

        assertThat(lottos.getLottos().size()).isEqualTo(count);
    }
}
