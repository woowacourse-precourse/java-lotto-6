package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.util.RateOfReturnUtil;
import lotto.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnUtilTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("calcRateOfReturn 테스트")
    @Test
    void testCalcRateOfReturn() {
        // given
        List<Integer> prizeCount = List.of(1, 1, 1, 1, 1);
        int cost = 1000 * prizeCount.stream().mapToInt(Integer::intValue).sum();
        String expected = "총 수익률은 40631100.0%입니다.";
        // when
        OutputView.printRateOfReturn(RateOfReturnUtil.calcRateOfReturn(cost, prizeCount));
        expected = expected.replaceAll("\\s", "");
        String actual = outputStreamCaptor.toString().trim().replaceAll("\\s", "");

        // then
        assertEquals(expected, actual);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
