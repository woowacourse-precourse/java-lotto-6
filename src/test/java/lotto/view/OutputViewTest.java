package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import static lotto.model.LottoPrize.PRIZE_1;
import static lotto.model.LottoPrize.PRIZE_2;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.model.Lotto;
import lotto.model.LottoPrizeCount;
import lotto.model.LottoStatistic;
import lotto.model.Lottos;

class OutputViewTest extends NsTest {

    OutputView outputView = new OutputView();

    @DisplayName("발행한 로또 수량 및 번호를 오름차순 정렬하여 출력한다.")
    @Test
    void printLottos() {
        // given
        Lottos lottos = Lottos.of(
                new Lotto(List.of(6, 5, 4, 3, 2, 1)),
                new Lotto(List.of(7, 5, 4, 3, 2, 1)),
                new Lotto(List.of(8, 5, 4, 3, 2, 1))
        );

        // when
        outputView.printLottos(lottos);

        // then
        assertThat(output()).contains(
                "3개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[1, 2, 3, 4, 5, 7]",
                "[1, 2, 3, 4, 5, 8]"
        );
    }

    @DisplayName("당첨 통계를 출력한다.")
    @Test
    void printStatistic() {
        // given
        int purchase = 2000;

        LottoPrizeCount prizeCount = LottoPrizeCount.from(List.of(PRIZE_1, PRIZE_2));

        double earningRate = (double) (PRIZE_1.getPrizeMoney() + PRIZE_2.getPrizeMoney()) / purchase;

        LottoStatistic statistic = LottoStatistic.of(prizeCount, earningRate);

        // when
        outputView.printStatistic(statistic);

        // then
        assertThat((output()))
                .contains(
                        "3개 일치 (5,000원) - 0개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                        "6개 일치 (2,000,000,000원) - 1개",
                        "총 수익률은 1015000.0%입니다."
                );
    }

    @Override
    protected void runMain() {
    }
}
