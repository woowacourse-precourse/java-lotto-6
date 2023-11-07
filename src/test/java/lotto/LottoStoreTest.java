package lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private LottoStore lottoStore = new LottoStore();

    @BeforeEach
    public void setUp() {
        lottoStore = new LottoStore();
    }

    @Test
    public void testCalculateTotalWinning() {
        List<Integer> counts = Arrays.asList(7, 0, 0, 0, 1, 1);
        lottoStore.setTotalWinningMoney(counts);
        BigDecimal compared = new BigDecimal(2030000000);
        assertEquals(compared, lottoStore.getTotalWinningMoney());
    }

    @Test
    void calculateRateOfReturnTest() {
        lottoStore.setTotalWinningMoney(new BigDecimal(5000));
        lottoStore.setLottoSales(8);
        BigDecimal rateOfReturn = lottoStore.calculateRateOfReturn();
        assertThat(rateOfReturn).isEqualByComparingTo(BigDecimal.valueOf(62.5));
    }

    @Test
    void rankLottosTest() {
        List<Integer>lottoRank = lottoStore.rankLottos(
                List.of(
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                        new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                        new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                        new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                        new Lotto(List.of(1, 3, 5, 14, 22, 45))
                ),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        assertThat(lottoRank).containsExactly(5, 1, 0, 0, 0, 0);
    }
}
