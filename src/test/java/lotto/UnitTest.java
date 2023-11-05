package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UnitTest extends NsTest {
    @DisplayName("입력 금액의 입력이 제대로 되었는지 확인")
    @Test
    void input_money_Test() {
        assertSimpleTest(() -> {
            run("1900", "a", "2000","1,2,3,4,5,6","7");
            assertThat(output()).contains(
                    "[ERROR] 입력 금액은 1000의 배수로 입력해주세요.",
                    "[ERROR] 숫자를 입력해 주세요",
                    "2개를 구매했습니다.");
        });
    }

    @DisplayName("로또 번호 입력 테스트")
    @Test
    void inputLottoNumbers_Test() {
        assertSimpleTest(() -> {
                    run("2000","1,2,3,4,5,6,7","1,1,2,3,4,5","1,2,3,4,5,100","1,2,3,4,5,6","7");
                    assertThat(output()).contains(
                            "[ERROR] 로또 번호는 6개의 수를 입력해주세요.",
                            "[ERROR] 로또 수는 중복 없이 입력해주세요.",
                            "[ERROR] 로또 번호 1부터 45까지의 수로 입력해주세요.");
                }
        );
    }

    @DisplayName("보너스 번호 입력 테스트")
    @Test
    void inputBonusNumbers_Test() {
        assertSimpleTest(() -> {
                    run("2000","1,2,3,4,5,6","100","a","6","7");
                    assertThat(output()).contains(
                            "[ERROR] 숫자를 입력해주세요.",
                            "[ERROR] 1부터 45까지의 숫자를 입력해주세요.",
                            "[ERROR] 당첨 번호인 [1, 2, 3, 4, 5, 6]를 제외한 번호를 입력해주세요.");
                }
        );
    }

    @DisplayName("번호 일치 테스트")
    @Test
    void checkResult_Test() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "8,10,21,23,41,43", "42");
                    assertThat(output()).contains(
                            "1개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}