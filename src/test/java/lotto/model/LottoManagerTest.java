package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.mock.TestLottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    private LottoManager lottoManager;
    private TestLottoGenerator mockGenerator;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
        mockGenerator = new TestLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 생성할 수 있다.")
    void makeLottosShouldCreateLottos() {
        int numberOfLottos = 5;

        lottoManager.createPurchaseLottos(numberOfLottos, mockGenerator);

        assertThat(lottoManager.getPurchaseLottos()).hasSize(numberOfLottos);
    }

    @Test
    @DisplayName("당첨 로또 생성할 수 있다.")
    void makeWinningLottoShouldCreateWinningLotto() {
        lottoManager.createPurchaseLottos(1, mockGenerator);
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        lottoManager.createWinningLotto(winningNumber, bonusNumber);

        assertThat(lottoManager.calculateLottoResult()).isNotNull();
    }

    @Test
    @DisplayName("로또 결과를 계산할 수 있다.")
    void calculateLottoResult() {
        lottoManager.createPurchaseLottos(1, mockGenerator);
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        lottoManager.createWinningLotto(winningLotto, bonusNumber);
        LottoResult result = lottoManager.calculateLottoResult();

        assertThat(result.getCount(WinningInfo.SIX_MATCH)).isEqualTo(1);
    }


    @Test
    @DisplayName("수익률을 계산할 수 있다.")
    void calculateRateOfReturnByLottoResult() {
        int numberOfLottos = 1;
        lottoManager.createPurchaseLottos(numberOfLottos, mockGenerator);

        int bonusNumber = 7;
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        lottoManager.createWinningLotto(winningLotto, bonusNumber);

        lottoManager.calculateLottoResult();
        double rateOfReturn = lottoManager.calculateRateOfReturn(1000);

        assertThat(rateOfReturn).isEqualTo(5.0);
    }
}