package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 번호_정렬_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "[1, 2, 3, 40, 41, 43]"
                    );
                },
                List.of(1, 3, 40, 2, 41, 43)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입_금액_테스트() {
        assertSimpleTest(() -> {
            runException("1234");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스_번호_1보다_작을때_테스트() {
        assertSimpleTest(
                () -> {
                    runException("1000", "1,2,3,4,5,6", "0");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 보너스_번호_45보다_클때_테스트() {
        assertSimpleTest(
                () -> {
                    runException("1000", "1,2,3,4,5,6", "46");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 보너스_번호_당첨_번호_중복_테스트() {
        assertSimpleTest(
                () -> {
                    runException("1000", "1,2,3,4,5,6", "6");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 수익률_테스트() {
        String rewardRate = new LottoGame().getRewardRate(8000, 5000);

        assertThat(rewardRate).isEqualTo("62.5");
    }

    @Test
    void 당첨_테스트() {
        LottoGame lottoGame = new LottoGame();
        HashMap<WinningLottoType, Integer> expectedWinningResultMap = lottoGame.makeWinningResultMap();
        expectedWinningResultMap.put(WinningLottoType.ALL, 1);
        expectedWinningResultMap.put(WinningLottoType.FIVE_BONUS, 1);
        expectedWinningResultMap.put(WinningLottoType.THREE, 1);

        HashMap<WinningLottoType, Integer> actualWinningResultMap = lottoGame.matchWinningResult(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                        new Lotto(List.of(31, 32, 33, 34, 35, 36))
                )
                , 7);

        assertThat(actualWinningResultMap).isEqualTo(expectedWinningResultMap);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}