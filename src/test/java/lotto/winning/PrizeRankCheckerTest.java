package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.purchasing.Generator;
import lotto.purchasing.PurchaseAmount;
import org.junit.jupiter.api.Test;

class PrizeRankCheckerTest {
    @Test
    public void prizeRankCheckTest() {
        Generator mockGenerator = new Generator(new PurchaseAmount());
        PrizeRankChecker prizeRankChecker = new PrizeRankChecker();

        List<Lotto> mockLottos =
                mockGenerator.issue(1, 1, 6, 6);

        assertThat(prizeRankChecker
                .computeMatchedNumberCounts(mockLottos, Arrays.asList(1,2,3,4,5,6)).get(0))
                .isEqualTo(6);
    }
}