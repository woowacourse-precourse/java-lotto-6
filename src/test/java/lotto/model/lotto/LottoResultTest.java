package lotto.model.lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest extends NsTest {
    @DisplayName("로또 3개 구매 후 로또 결과 출력 테스트")
    @Test
    void 로또_결과_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("3000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개를 구매했습니다.",
                            "3개 일치 (5,000원) - 2개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 2,000.0%입니다."
                    );
                },
                List.of(1, 2, 3, 7, 8, 9),
                List.of(4, 5, 6, 7, 8 ,9),
                List.of(1, 2, 3, 4, 7, 8)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
