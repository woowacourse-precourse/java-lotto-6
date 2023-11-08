package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {
    private LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory();
    }

    @DisplayName("사용자가 입력한 금액을 로또 금액으로 나눠서 구매 개수를 반환한다.")
    @Test
    void calculateNumberOfLottos() {
        //given
        int userPurchaseAmount = 2000;

        //when
        int numberOfLottos = lottoFactory.calculateNumberOfLottos(userPurchaseAmount);

        //then
        assertThat(numberOfLottos).isEqualTo(2);
    }

    @DisplayName("구매한 로또를 개수만큼 발급한다.")
    @Test
    void getPurchasedLottos() {
        //given
        int numberOfLottos = 2;

        //when
        List<Lotto> purchasedLottos = lottoFactory.getPurchasedLottos(numberOfLottos);

        //then
        assertThat(purchasedLottos.size()).isEqualTo(2);
    }

    @DisplayName("당첨 번호와 로또 번호를 비교해서 결과를 계산한다.")
    @Test
    void calculateResults() {
        //given
        int bonusNumber = 45;
        int userPurchaseAmount = 8000;
        List<Lotto> purchasedLottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(11, 12, 13, 24, 25, 26));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        purchasedLottos.add(lotto1);
        purchasedLottos.add(lotto2);

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 34, 35, 36));
        LottoResult lottoResult = new LottoResult();

        //when
        lottoFactory.calculateResults(purchasedLottos, winningLotto, bonusNumber, lottoResult);

        //then
        assertThat(lottoResult.getRoundedReturn(userPurchaseAmount)).isEqualTo(62.5);

    }
}