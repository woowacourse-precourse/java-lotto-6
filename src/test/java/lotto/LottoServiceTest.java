package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoData;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoServiceTest {

    private static final int HUNDRED = 100;
    final LottoService lottoService = new LottoService(new RandomNumberGenerator());

    @Test
    @DisplayName("입력 금액에 맞춰 개수만큼 로또 번호를 발급 받는다.")
    void 입력된_금액_만큼_로또번호를_발급_받는_테스트() {
        final User case1 = new User(new Amount(10000)); // 10개 구매
        final User case2 = new User(new Amount(20000)); // 20개 구매

        lottoService.buyLottoTickets(case1);
        lottoService.buyLottoTickets(case2);

        assertThat(case1.getLottos().size()).isEqualTo(10);
        assertThat(case2.getLottos().size()).isEqualTo(20);
    }

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void testGenerateLottoNumbers() {
        User user = new User(new Amount(10000)); // 10개 구매

        lottoService.buyLottoTickets(user);

        for (Lotto lotto : user.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Test
    @DisplayName("로또 당첨 번호와 보너스 번호 설정 테스트")
    void 로또_당첨_번호_보너스_번호_설정_테스트() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        LottoData lottoData = lottoService.generateWinningNumbers(winningNumbers, bonusNumber);

        assertThat(lottoData.winningNumbers()).isEqualTo(winningNumbers);
        assertThat(lottoData.bonusNumber()).isEqualTo(bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000, 20000, 50000})
    @DisplayName("로또 총 수익률 계산 테스트")
    void calculateProfitPercentage(int purchaseAmount) {
        User user = new User(new Amount(purchaseAmount));
        lottoService.buyLottoTickets(user);

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        LottoData lottoData = lottoService.generateWinningNumbers(winningNumbers, bonusNumber);

        lottoService.checkWinningsForUserLottos(user, lottoData);

        double expectedTotalPrize = lottoService.calculateTotalPrize(lottoService.getWinningCounts());
        double profitPercentage = HUNDRED + ((expectedTotalPrize - purchaseAmount) / purchaseAmount) * HUNDRED;

        // 수익률은 0 또는 양수이어야 합니다.
        Assertions.assertThat(profitPercentage).isGreaterThanOrEqualTo(0);
    }
}
