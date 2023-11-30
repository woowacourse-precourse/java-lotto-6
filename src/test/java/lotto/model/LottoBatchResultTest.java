package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LottoBatchResultTest {
    private LottoBatch lottoBatch;
    private PrizeNumbers prizeNumbers;

    @BeforeEach
    public void setUp() {
        lottoBatch = mock(LottoBatch.class);
        prizeNumbers = new PrizeNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        prizeNumbers.setBonusNumber(7);

        when(lottoBatch.getLottos()).thenReturn(generateLottos());

    }

    private List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 9))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 10, 11, 12))));
        return lottos;
    }

    @DisplayName("생성된 로또가 당첨번호와 보너스번호에 따라 결과 결정")
    @Test
    void calculateLottoResultsTest() {
        LottoBatchResult lottoBatchResult = new LottoBatchResult(lottoBatch, prizeNumbers);
        lottoBatchResult.calculateLottoResults();

        assertThat(lottoBatchResult.getValue()).containsExactly(LottoResult.FIRST_PRIZE, LottoResult.SECOND_PRIZE, LottoResult.THIRD_PRIZE, LottoResult.FIFTH_PRIZE);

    }
}
