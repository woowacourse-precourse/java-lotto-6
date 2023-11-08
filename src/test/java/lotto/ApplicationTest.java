package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Constant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final LottoService lottoService = new LottoService();
    private List<Integer> winnerNums;
    private int bonusNum = 7;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        winnerNums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        bonusNum = 7;
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // SIX
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // FIVE_BONUS
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // FIVE
                new Lotto(List.of(1, 2, 3, 4, 9, 8)), // FOUR
                new Lotto(List.of(1, 2, 3, 9, 10, 8)), // THREE
                new Lotto(List.of(1, 2, 9, 10, 11, 8)) // LOSE
        );
    }

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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구매한 금액에 맞게 로또 티켓을 발행한다.")
    @ParameterizedTest
    @ValueSource(ints = {300, 1000, 2005, 3300, 4000, 5000, 6000, 7000})
    void generateLottosTest(int purchaseAmount) {
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);
        assertThat(lottos.size()).isEqualTo(purchaseAmount / LOTTO_PRICE);
    }

    @DisplayName("로또별로 당첨 결과를 확인한다.")
    @Test
    void getResultsTest() {
        // when
        List<Integer> results = lottoService.getResults(lottos, winnerNums, bonusNum);

        // then
        List<Integer> expected = List.of(1, 1, 1, 1, 1, 1);
        assertThat(results).isEqualTo(expected);
    }

    @DisplayName("수익률이 옳바르게 계산되어야 한다.")
    @Test
    void calculateEarningRateTest() {
        // given
        List<Integer> results = lottoService.getResults(lottos, winnerNums, bonusNum);

        // when
        double earningRate = lottoService.calculateEarningRate(results, LOTTO_PRICE*lottos.size());

        // then
        assertThat(earningRate).isEqualTo(33859250);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
