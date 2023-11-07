package lotto.domain.component;

import lotto.domain.component.LottoFactory;
import lotto.domain.component.LottoStore;
import lotto.domain.dto.Purchase;
import lotto.domain.model.Lottos;
import lotto.domain.model.Money;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoStoreTest {

    @Test
    void 구입금액에_맞는_로또를_반환한다() {
        List<Integer> generatedLotto = List.of(1, 2, 3, 4, 5, 6);
        LottoStore store = new LottoStore(new LottoFactory(() -> generatedLotto));
        Money money = new Money(1000);
        Lottos expectedLottos = new Lottos();
        expectedLottos.addLotto(generatedLotto);
        Purchase expected = new Purchase(1, expectedLottos);

        Purchase actual = store.sellLottos(money);

        assertEquals(expected, actual);
    }
}
