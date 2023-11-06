package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.policy.LottoNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 발행 테스트")
public class LottoStoreTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "9900000"})
    @DisplayName("[정상처리] 구입 금액에 해당하는 로또를 발행한다.")
    void 로또_발행_정상처리(String purchaseAmount) {
        Amount amount = new Amount(purchaseAmount);
        LottoStore lottoStore = new LottoStore(() ->
                Randoms.pickUniqueNumbersInRange(
                        LottoNumbersGenerator.MIN_NUMBER,
                        LottoNumbersGenerator.MAX_NUMBER,
                        LottoNumbersGenerator.NUMBER_COUNT));
        int ticketCount = Integer.parseInt(purchaseAmount) / 1000;

        SoldLotto soldLotto = lottoStore.sell(amount);

        Assertions.assertThat(soldLotto.getSoldLottoTicketsCount())
                .isEqualTo(ticketCount);
    }

    @Test
    @DisplayName("[정상처리] 1장의 로또를 발행하고 번호를 비교한다.")
    void 로또_발행_1장_번호비교_정상처리() {
        Amount amount = Amount.DEFAULT_PURCHASE_AMOUNT;
        LottoStore lottoStore = new LottoStore(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        SoldLotto soldLotto = lottoStore.sell(amount);

        Assertions.assertThat(soldLotto.getSoldLottoTicketsCount())
                .isEqualTo(1);
        Assertions.assertThat(soldLotto.toString().trim())
                .isEqualTo(lotto.toString());
    }
}
