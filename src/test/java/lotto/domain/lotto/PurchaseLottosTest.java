package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.generator.AutoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchaseLottosTest {
    private PurchaseLottos purchaseLottos;

    @DisplayName("구입가격을 1000으로 나눈만큼 로또를 구매한다.")
    @ParameterizedTest
    @CsvSource({"2000,2", "5000,5", "10000,10"})
    void purchaseLottosByPrice(int price, int expected) {
        purchaseLottos = new PurchaseLottos(PurchasePrice.from(price), new AutoGenerator());
        int actual = purchaseLottos.getPurchaseCount();
        assertThat(actual).isEqualTo(expected);
    }
}
