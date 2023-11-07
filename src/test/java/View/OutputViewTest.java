package View;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest extends NsTest {
    @DisplayName("생성된 로또는 오름차순으로 출력되어야 한다")
    @Test
    void printLottoByAscending() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("2000");
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]"
                    );
                },
                List.of(23, 21, 8, 41, 42, 43),
                List.of(3, 11, 5, 38, 32, 16)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}