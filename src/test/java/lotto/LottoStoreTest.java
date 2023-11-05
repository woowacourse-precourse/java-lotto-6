package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 발행 테스트")
public class LottoStoreTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "9900000"})
    @DisplayName("[정상처리]")
    void 로또_발행_정상처리(String purchaseAmount) {
        Amount amount = new Amount(purchaseAmount);
        LottoStore lottoStore = new LottoStore(() -> Randoms.pickUniqueNumbersInRange(1, 45, 6));
        int ticketCount = Integer.parseInt(purchaseAmount) / 1000;

        SoldLotto lottos = lottoStore.sell(amount);

        Assertions.assertThat(lottos.getSoldLottoCount())
                .isEqualTo(ticketCount);
    }

    @Test
    @DisplayName("[정상처리] 1장 번호 비교")
    void 로또_발행_1장_번호비교_정상처리() {
        Amount amount = new Amount("1000");
        LottoStore lottoStore = new LottoStore(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        SoldLotto lottos = lottoStore.sell(amount);

        Assertions.assertThat(lottos.getSoldLottoCount())
                .isEqualTo(1);
        Assertions.assertThat(lottos.toString().trim())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
