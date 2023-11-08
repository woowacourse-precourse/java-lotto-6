package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LottoGameTest {
    private LottoGame lottoGame;
    private int inputAmount;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
        inputAmount = 3000;
    }

    @DisplayName("금액만큼의 로또가 생성되는지 테스트한다.")
    @Test
    void testPurchaseLottosCount() {
        int expectedLottoCount = inputAmount / 1000;

        List<Lotto> purchasedLottos = lottoGame.purchaseLottos(inputAmount);

        assertThat(purchasedLottos).hasSize(expectedLottoCount);
    }

    @DisplayName("로또 객체가 올바르게 생성되는지 테스트한다.")
    @Test
    void testPurchaseLottosCreation() {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generateRandomNumbers()).thenReturn(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottoGame.randomNumberGenerator = randomNumberGenerator;

        List<Lotto> resultLottos = lottoGame.purchaseLottos(inputAmount);

        assertThat(resultLottos.get(0).getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}