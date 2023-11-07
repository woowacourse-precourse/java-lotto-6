package lotto.winning;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.purchasing.Generator;
import lotto.purchasing.PurchaseAmount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrizeRankCheckerTest {
    String mockInput = "1000";

    @BeforeEach
    public void setUpStreams() {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(System.in);
        Console.close();
    }
    @Test
    public void prizeRankCheckTest() {
        Generator mockGenerator = new Generator(new PurchaseAmount().ask());
        PrizeRankChecker prizeRankChecker = new PrizeRankChecker();

        List<Lotto> mockLottos =
                mockGenerator.issue(1, 6, 6);

        assertThat(prizeRankChecker
                .computeMatchedNumberCounts(mockLottos, Arrays.asList(1,2,3,4,5,6)).get(0))
                .isEqualTo(6);
    }
}