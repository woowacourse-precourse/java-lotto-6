package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private RandomGenerator randomGenerator;

    private LottoMachine lottoMachine;

    @BeforeEach
    void setup() {
        randomGenerator = mock(RandomGenerator.class);
        lottoMachine = new LottoMachine(randomGenerator);
    }

    @Test
    @DisplayName("자동 발급 시 임의의 로또 번호들이 생성되어야 한다")
    void givenRandomNumbers_whenIssueAutomatically_thenShouldCreateLottoWithThoseNumbers() {
        // Given
        List<Integer> mockNumbers = List.of(1, 2, 3, 24, 42, 45);
        given(randomGenerator.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.SIZE))
                .willReturn(mockNumbers);

        // When
        Lotto lotto = lottoMachine.issueAutomatically();

        // Then
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(mockNumbers);
    }

    @Test
    @DisplayName("구입 금액에 따라 적절한 수의 로또가 자동 발급되어야 한다")
    void givenPurchaseAmount_whenIssueAutomatically_thenShouldCreateCorrectNumberOfLottos() {
        // Given
        int purchaseAmount = 2_000;
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(Integer.toString(purchaseAmount));
        int expectedLottoTicketsCount = lottoPurchaseAmount.getTicketsCount();

        List<Integer> firstMockNumbers = List.of(1, 2, 3, 24, 42, 45);
        List<Integer> secondMockNumbers = List.of(4, 5, 6, 25, 43, 44);

        given(randomGenerator.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.SIZE))
                .willReturn(firstMockNumbers)
                .willReturn(secondMockNumbers);

        // When
        List<Lotto> lottos = lottoMachine.issueAutomatically(lottoPurchaseAmount);

        // Then
        assertThat(lottos).hasSize(expectedLottoTicketsCount);

        assertThat(lottos.get(0).getNumbers()).isEqualTo(firstMockNumbers);
        assertThat(lottos.get(1).getNumbers()).isEqualTo(secondMockNumbers);
    }
}
