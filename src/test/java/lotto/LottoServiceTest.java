package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

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
}
