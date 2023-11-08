package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
                            "총 수익률은 395000.0%입니다."
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

    @ParameterizedTest
    @DisplayName("돈 입력의 모든 에러 경우 메세지가 [ERROR]를 포함하고 있는지 확인합니다.")
    @ValueSource(strings = {"\n", " ", "1000j"})
    void contain_ERROR_input_Money(String target) {
        assertSimpleTest(() -> {
            runException(target);
            assertThat(output()).contains("[ERROR]");
        });
    }

    @ParameterizedTest
    @DisplayName("로또 6자리 입력의 모든 에러 경우 메세지가 [ERROR]를 포함하고 있는지 확인합니다.")
    @ValueSource(strings = {"\n", " ", "1,2,3,4,5,k", ",1,2,3,4,5,6", "1,2,3,4,5,6,", "1,2,3,4,5", "1,2,3,4,5,46",
            "0,1,2,3,4,5",
            "1,1,2,3,4,5"})
    void contain_ERROR_input_Lotto(String target) {
        assertSimpleTest(() -> {
            runException("5000", target);
            assertThat(output()).contains("[ERROR]");
        });
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 입력의 모든 에러 경우 메세지가 [ERROR]를 포함하고 있는지 확인합니다.")
    @ValueSource(strings = {"\n", " ", "k", ",1,2", "0", "46", "1"})
    void contain_ERROR_input_Bonus(String target) {
        assertSimpleTest(() -> {
            runException("5000", "1,2,3,4,5,6", target);
            assertThat(output()).contains("[ERROR]");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
