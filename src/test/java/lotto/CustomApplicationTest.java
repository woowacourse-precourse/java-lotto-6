package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.constant.ErrorMessage.NOT_ENOUGH_MONEY;
import static lotto.constant.InputMessage.LOTTO_PURCHASE_MONEY;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomApplicationTest extends NsTest{

    @DisplayName("사용자가 잘못된 값을 입력시 재입력을 받도록 한다.")
    @Test
    void 재입력_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("300", "3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            LOTTO_PURCHASE_MONEY,
                            NOT_ENOUGH_MONEY,
                            "3개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.0%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
