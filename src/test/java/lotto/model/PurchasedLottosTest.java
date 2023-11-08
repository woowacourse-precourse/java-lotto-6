package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.mock.TestLottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottosTest {
    LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        lottoGenerator = new TestLottoGenerator(validNumbers);
    }

    @DisplayName("PurchasedLottos 생성 및 로또 목록 확인")
    @Test
    void createPurchasedLottosAndCheckLottoList() {
        int numberOfLottos = 5;
        PurchasedLottos purchasedLottos = PurchasedLottos.of(numberOfLottos, lottoGenerator);

        assertThat(purchasedLottos).isNotNull();
        assertThat(purchasedLottos.getPurchaseLottos()).hasSize(numberOfLottos);
    }

    @DisplayName("당첨 정보 확인")
    @Test
    void checkWinningInfos() {
        int numberOfLottos = 1;
        PurchasedLottos purchasedLottos = PurchasedLottos.of(numberOfLottos, lottoGenerator);
        WinningLotto winningLotto = WinningLotto.of(new Lotto(List.of(1, 2, 3, 4, 5, 9)), 6);

        List<WinningInfo> winningInfos = purchasedLottos.getWinnningInfos(winningLotto);

        assertThat(winningInfos.get(0)).isEqualTo(WinningInfo.FIVE_AND_BONUS_MATCH);
    }


}