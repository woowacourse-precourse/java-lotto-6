package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BuyCash;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.util.AppConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameControllerTest extends NsTest {
    private static LottoGameController controller;

    @BeforeAll
    static void 초기_설정() {
        AppConfig appConfig = AppConfig.getInstance();
        controller = appConfig.lottoGameController();
    }

    @DisplayName("로또구매 금액에 따른 수량 및 번호 반환(buy_unit=1000)")
    @Test
    void 로또_구매_결과_반환() {
        //given
        long cash = 5000;
        long buyAmountExpected = 5;

        List<Lotto> expectedLottos = new ArrayList<>();
        expectedLottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        expectedLottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        expectedLottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        expectedLottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        expectedLottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    BuyCash buyCash = new BuyCash(cash);
                    Lottos lottos = controller.purchaseLotto(buyCash);
                    assertThat(lottos.getLottoAmount()).isEqualTo(buyAmountExpected);

                    List<Lotto> lottoTickets = lottos.getLottoTickets();

                    for (int index = 0; index < lottoTickets.size(); index++) {
                        assertThat(lottoTickets.get(index).getNumbersMessage())
                                .isEqualTo(expectedLottos.get(index).getNumbersMessage());
                    }
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );

    }

    @DisplayName("구매 로또들과 당첨번호 비교 및 등수 결과 반환 기능")
    @Test
    void 결과_계산_기능() {
        //given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bounsNumber = new LottoNumber(7);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bounsNumber);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        Lottos userLottos = new Lottos(lottos);

        Map<Rank, Long> expected = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank -> expected.put(rank, 0L));
        expected.put(Rank.FIFTH, 1L);

        //when
        Result result = controller.getResult(userLottos, winningLotto);

        //then
        Arrays.stream(Rank.values())
                .forEach(rank -> assertThat(result.getProfit(rank)).isEqualTo(rank.getRankReward(expected.get(rank))));
    }

    @Override
    public void runMain() {

    }
}
