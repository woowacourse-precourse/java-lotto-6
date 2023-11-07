package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultNotifierTest {

    @DisplayName("로또 두 장을 발급받았을 때 모두 당첨번호와 6개일치하면 1등 2개로 등록된다")
    @Test
    void onePrize_2Count_when_allMatch_lotto() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 10);

        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        LottoResultNotifier notifier = new LottoResultNotifier(lottos, lottoDraw);

        Map<LottoResult, Integer> result = notifier.getResultMap();

        assertThat(result.get(LottoResult.FIRST_PRIZE))
                .isEqualTo(2);

        assertThat(result.get(LottoResult.NO_PRIZE))
                .isEqualTo(0);


    }

    @DisplayName("로또 두장을 발급받았을 때 당첨번호가 2등 1개 3등 1개일때 정상적으로 맵에 1개씩 표시")
    @Test
    void secondPrizeAndThirdPrize_2Count_when_allMatch_lotto() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 4, 5, 6, 10));
        Lotto lotto2 = new Lotto(List.of(1, 3, 4, 5, 6, 40));

        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 10);

        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        LottoResultNotifier notifier = new LottoResultNotifier(lottos, lottoDraw);

        Map<LottoResult, Integer> result = notifier.getResultMap();

        assertThat(result.get(LottoResult.SECOND_PRIZE))
                .isEqualTo(1);

        assertThat(result.get(LottoResult.THIRD_PRIZE))
                .isEqualTo(1);
    }

    @DisplayName("로또 두장을 발급받았을 때 당첨번호가 4등 1개 5등 1개일때 정상적으로 맵에 1개씩 표시")
    @Test
    void fourthPrizeAndFifthPrize_2Count_when_allMatch_lotto() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 8, 10));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 9, 11, 40));

        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 10);

        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        LottoResultNotifier notifier = new LottoResultNotifier(lottos, lottoDraw);

        Map<LottoResult, Integer> result = notifier.getResultMap();

        assertThat(result.get(LottoResult.FOURTH_PRIZE))
                .isEqualTo(1);

        assertThat(result.get(LottoResult.FIFTH_PRIZE))
                .isEqualTo(1);
    }

    @DisplayName("1등 1개 2등 2개 당첨되었을 때 당첨금액이 정상적이어야 한다")
    @Test
    void nomal_when_onePrizeCount1_and_twoPrizeCount2() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 10);

        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));

        LottoResultNotifier notifier = new LottoResultNotifier(lottos, lottoDraw);

        assertThat(notifier.getTotalWinningAmount())
                .isEqualTo(LottoResult.FIRST_PRIZE.getAmount() + LottoResult.SECOND_PRIZE.getAmount() * 2);

    }

    @DisplayName("사용자가 로또를 사면 수익률은 소수점 둘째자리에서 반올림 되어야 한다")
    @Test
    void roundedTwoDecimalPlaceWhenUserBuyLotto() {
        //when 5등 당첨
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        LottoDraw lottoDraw = new LottoDraw(List.of(1, 2, 3, 4, 5, 6), 10);

        Lottos lottos = new Lottos(List.of(lotto1));
        LottoResultNotifier notifier = new LottoResultNotifier(lottos, lottoDraw);

        assertThat(notifier.getRateOfReturn())
                .isEqualTo("500.0");
    }

}
