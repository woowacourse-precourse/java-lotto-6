package lotto.module.manager;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.global.factory.LottoManagerFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_당첨_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 166.7%입니다."
                    );
                },
                List.of(43, 21, 23, 8, 41, 42),
                List.of(16, 3, 5, 11, 32, 38),
                List.of(22, 45, 1, 3, 5, 14)
        );
    }

    @Test
    void 로또_미당첨_기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[2, 13, 22, 32, 38, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(43, 21, 23, 8, 41, 42),
                List.of(16, 3, 5, 11, 32, 38),
                List.of(22, 32, 38, 2, 13, 45)
        );
    }

    @Test
    void 최소_구매금_예외_테스트() {
        assertSimpleTest(() -> {
            runException("900");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 최대_구매금_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000000000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        LottoManager lottoManager = LottoManagerFactory.getSingletonLottoManager();
        lottoManager.run();
    }

}