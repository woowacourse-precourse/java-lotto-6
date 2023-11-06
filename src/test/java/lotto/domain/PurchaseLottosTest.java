package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.AutoGenerator;
import lotto.util.ManualGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("구입한 로또 번호가 오름차순으로 출력된다.")
    @Test
    void getPurchaseLottoNumbers() {
        purchaseLottos = new PurchaseLottos(PurchasePrice.from(1000), new ManualGenerator());
        String actual = purchaseLottos.getPurchaseLottos();
        String expected = "1, 2, 3, 4, 5, 6";
        assertThat(actual.contains(expected));
    }
}
