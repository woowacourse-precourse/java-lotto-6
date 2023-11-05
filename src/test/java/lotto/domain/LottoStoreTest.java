package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    LottoStore lottoStore = new LottoStore();

    @DisplayName("로또 구매가 정상적으로 완료했을 경우 통과한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000, 1000, 10000, 100000, 1000000})
    void buyLottoTickets(int count) {
        List<Lotto> lottoList = lottoStore.buyLottoTickets(count);
        Assertions.assertEquals(count, lottoList.size());
    }


}