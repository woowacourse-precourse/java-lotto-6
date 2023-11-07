package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구매한 로또 테스트")
class PurchasedLottosTest {

    @DisplayName("로또를 장당 1000원에 구입 금액에 해당하는 만큼 로또를 발행해야 한다.")
    @Test
    public void createPurchasedLottos_ShouldGenerateCorrectNumberOfLottos() {
        NumberGenerator generator = new RandomNumberGenerator();
        Money money = new Money("5000");
        PurchasedLottos purchasedLottos = PurchasedLottos.createPurchasedLottos(generator, money);

        assertThat(purchasedLottos.purchasedLottosCount()).isEqualTo(5);
    }

    @DisplayName("당첨 번호와 구매한 로또를 비교하여 등수 리스트를 반환한다.")
    @Test
    public void testMatchLottos() {
        //항상 고정된 1,2,3,4,5,6의 로또를 생성하는 StubLottoNumberGenerator
        NumberGenerator testGenerator = new StubLottoNumberGenerator();
        Money money = new Money("2000");
        PurchasedLottos purchasedLottos = PurchasedLottos.createPurchasedLottos(testGenerator, money);
        WinningLotto winningLotto = WinningLotto.createWinningLotto("1,2,3,4,5,6", "7");

        List<LottoRank> matchedRanks = purchasedLottos.matchLottos(winningLotto);

        assertThat(matchedRanks).containsExactly(LottoRank.FIRST, LottoRank.FIRST);
    }

    //항상 고정된 1,2,3,4,5,6의 로또를 생성하는 StubLottoNumberGenerator
    static class StubLottoNumberGenerator implements NumberGenerator {

        @Override
        public List<Integer> generate(int size) {
            return Arrays.asList(1, 2, 3, 4, 5, 6);
        }
    }
}