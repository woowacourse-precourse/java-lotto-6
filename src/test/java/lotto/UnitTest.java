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
            run("1900", "a", "2000");
            assertThat(output()).contains(
                    "[ERROR] 입력 금액은 1000의 배수로 입력해주세요.",
                    "[ERROR] 숫자를 입력해 주세요",
                    "2개를 구매했습니다.");
        });
    }

    @DisplayName("로또 번호가 잘 생성되는지 테스트")
    @Test
    void create_lotto_Test() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    run("2000");
                    assertThat(output()).contains(
                            "[8, 21, 23, 41, 42, 43]",
                            "[7, 21, 23, 41, 42, 43]");
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(8, 21, 23, 41, 42, 43),
                List.of(7, 21, 23, 41, 42, 43)
        );
    }

    @DisplayName("로또 번호가 잘 생성되는지 테스트")
    @Test
    void inputLottoNumbers_Test() {
        assertSimpleTest(() -> {
                    run("2000","1,2,3,4,5,6,7","1,1,2,3,4,5","1,2,3,4,5,100","1,2,3,4,5,6");
                    assertThat(output()).contains(
                            "[ERROR] 로또 번호는 6개의 수를 입력해주세요.",
                            "[ERROR] 로또 수는 중복 없이 입력해주세요.",
                            "[ERROR] 로또 번호 1부터 45까지의 수로 입력해주세요.");
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}