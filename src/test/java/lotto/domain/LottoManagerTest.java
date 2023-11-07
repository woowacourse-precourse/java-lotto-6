package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.configure.DomainConfiguration;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class LottoManagerTest {

    @Test
    void testExtractResult() {
        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                7
        );
        List<Lotto> testCases = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 28)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 10, 11)),
                new Lotto(Arrays.asList(4, 3, 5, 6, 15, 27)),
                new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16))
        );
        int[] expected = {
                2, 1, 1, 2, 1
        };

        LottoManager lottoManager = new LottoManager(winningNumbers, testCases);
        Result result = lottoManager.processLotto();
        for (int i = 0; i < DomainConfiguration.RANGE_OF_RANK; i++) {
            assertThat(result.getCount(i + 1)).isEqualTo(expected[i]);
        }
    }

    @Test
    void testGetPurchasePrice() {
        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                7
        );
        List<Lotto> lotto = List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 28)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 10, 11)),
                new Lotto(Arrays.asList(4, 3, 5, 6, 15, 27)),
                new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)),
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16))
        );

        LottoManager testCase = new LottoManager(winningNumbers, lotto);

        assertThat(testCase.getPurchasePrice()).isEqualTo(DomainConfiguration.PRICE_OF_LOTTO * lotto.size());
    }
}