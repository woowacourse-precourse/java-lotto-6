package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

    static final Integer LOTTO_PRICE = 1000;

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000})
    @DisplayName("로또 구매 금액에 따른 로또 수량 계산")
    public void testGetLottoQuantity(int moneyAmount) {
        Money money = new Money(moneyAmount);
        LottoStore lottoStore = new LottoStore();
        int expectedQuantity = moneyAmount / LottoStore.LOTTO_PRICE;
        int actualQuantity = lottoStore.getLottoQuantity(money);

        assertEquals(expectedQuantity, actualQuantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    @DisplayName("로또 수량에 따른 로또 생성 테스트")
    public void testGenerateLotto(int quantity) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.getLottoQuantity(new Money(quantity * LOTTO_PRICE));
        List<Lotto> lottos = lottoStore.generateLotto();

        assertEquals(quantity, lottos.size());
    }
}
