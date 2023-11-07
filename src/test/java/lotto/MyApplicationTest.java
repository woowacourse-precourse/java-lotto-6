package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class MyApplicationTest extends NsTest {

    @Test
    void 기능_테스트2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "8,11,21,23,41,42", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]", // 5개 일치
                            "[7, 8, 21, 23, 41, 42]", // 5개 보너스
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]", // 4개 일치
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 21, 23, 41, 42, 43]", // 4개
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 2개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 378125.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(7, 8, 21, 23, 41, 42),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 21, 23, 41, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트_중복된_당첨번호() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        });
    }

    @Test
    void 예외_테스트_중복된_당첨번호_보너스번호() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains("[ERROR] 보너스 값은 입력된 6자리 값과 중복될 수 없습니다.");
        });
    }

    @Test
    void 예외_테스트_숫자가_아닌_당첨번호() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,k");
            assertThat(output()).contains("[ERROR] 반드시 숫자로만 입력해야 합니다.");
        });
    }

    @Test
    void 예외_테스트_숫자가_아닌_보너스번호() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "k");
            assertThat(output()).contains("[ERROR] 반드시 숫자로만 입력해야 합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
