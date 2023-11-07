package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest extends NsTest {

    @DisplayName("1개 구매, 5등 수익률 테스트")
    @Test
    void fifthProfitTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 500.0%입니다."

                    );
                },
                List.of(1, 2, 3, 45, 44, 43)
        );
    }

    @DisplayName("1개 구매, 4등 수익률 테스트")
    @Test
    void fourthProfitTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 5,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 45, 44)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
