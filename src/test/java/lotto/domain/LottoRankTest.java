package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.dto.AllLotteriesNumbersInfoDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

class LottoRankTest extends NsTest {

    @Test
    void 로또_순위_테스트() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("6000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 3개",
                            "총 수익률은 100500916.7%입니다."
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,10,11),
                List.of(1,2,3,19,10,32)
        );
    }

    @Test
    void 로또_순위_테스트_모든순위_당첨() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("14000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 10개",
                            "총 수익률은 143082535.7%입니다."
                    );
                },
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,6),

                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,10),
                List.of(1,2,3,4,10,11),
                List.of(1,2,3,19,10,32)
        );
    }

    @Test
    void 로또_입력_정렬_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("7000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "7개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 6, 7]",
                            "[1, 3, 4, 5, 6, 20]",
                            "[1, 2, 4, 5, 6, 21]",
                            "[1, 2, 4, 6, 19, 24]",
                            "[1, 3, 5, 6, 7, 10]",
                            "[3, 5, 6, 7, 19, 23]",

                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 2개",
                            "5개 일치 (1,500,000원) - 2개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 29044357.1%입니다."
                    );
                },
                List.of(1,2,6,3,4,5),

                List.of(3,2,1,4,7,6),

                List.of(1,20,3,6,5,4),
                List.of(6,2,21,4,5,1),

                List.of(1,2,24,4,19,6),
                List.of(1,10,3,7,5,6),

                List.of(7,6,3,23,5,19)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}