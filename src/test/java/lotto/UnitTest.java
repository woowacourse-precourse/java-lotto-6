package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Application.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private static final ArrayList<Lotto> lottos = new ArrayList<>(
            List.of(
                    new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                    new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                    new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                    new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                    new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                    new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                    new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                    new Lotto(List.of(1, 3, 5, 14, 22, 45))
            )
    );

    @Test
    void testGetLottoPurchasePrice() {
        assertSimpleTest(() -> {
            runException("1001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void testReceiveWinningNumbers() {
        String input = "1,2,3,4,5";
        int[] expectedOutput = {1, 2, 3, 4, 5};
        int[] result = receiveWinningNumbers(input);
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    void testGetMatchCountByRank() {
        HashMap<Application.LottoRank, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put(Application.LottoRank.FIFTH, 1);
        expectedOutput.put(Application.LottoRank.FOURTH, 0);
        expectedOutput.put(Application.LottoRank.THIRD, 0);
        expectedOutput.put(Application.LottoRank.SECOND, 0);
        expectedOutput.put(Application.LottoRank.FIRST, 0);
        HashMap<Application.LottoRank, Integer> result = getMatchCountByRank(lottos, new int[]{1, 2, 3, 4, 5, 6}, 7);
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    void testGetEarnedMoney() {
        HashMap<Application.LottoRank, Integer> input = new HashMap<>();
        input.put(Application.LottoRank.FIFTH, 1);
        input.put(Application.LottoRank.FOURTH, 0);
        input.put(Application.LottoRank.THIRD, 0);
        input.put(Application.LottoRank.SECOND, 0);
        input.put(Application.LottoRank.FIRST, 0);
        int expectedOutput = 5000;
        int result = getEarnedMoney(input);
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Test
    void testGetRevenueRate() {
        int input1 = 5000;
        int input2 = 8000;
        double expectedOutput = 62.5;
        double result = getRevenueRate(input1, input2);
        assertThat(result).isEqualTo(expectedOutput);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
