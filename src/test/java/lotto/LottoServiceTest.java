package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("기능 테스트 - 오름차순 되지 않은 Lisof를 테스트")
    @Test
    void 기능_테스트_오름차순() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,21,23,4,5,6", "7");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 500.0%입니다."
                    );
                },
                List.of(21, 41, 43, 8, 42, 23)
        );
    }

    @DisplayName("로또 구입 금액 - 입력에 대한 예외 처리")
    @Test
    void 예외_테스트_로또_구입_금액() {
        assertSimpleTest(() -> {
            runException("five hundred dollars");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("2500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("0500");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 당첨 번호 - 입력에 대한 에외 처리")
    @Test
    void 예외_테스트_로또_당첨_번호() {
        assertSimpleTest(() -> {
            runException("2000", "1,2,3,4,5,47");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("3000", "-1,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("4000", "1,2,3,4");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("6000", "01,02,03,04,05,06");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("7000", "1, 2, 3, 4, 5, 6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("7000", "1/2/3/4/5/6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 보너스 번호 - 입력에 대한 에외 처리")
    @Test
    void 예외_테스트_보너스_번호() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "2,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("9000", "1,2,3,4,5,6", "/");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "07");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("10000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
