package lotto.service;

import static lotto.fixture.LottoFixture.createBonusBall;
import static lotto.fixture.LottoFixture.createLotto;
import static lotto.fixture.LottoFixture.createLottoPurchase;
import static lotto.fixture.LottoFixture.createLottoPurchaseAmount;
import static lotto.fixture.LottoFixture.createWinningLotto;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.common.constants.LottoRank;
import lotto.controller.dto.output.WinningLottoResultDto;
import lotto.model.lotto.WinningTicket;
import lotto.model.purchase.LottoPurchase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningStatisticsServiceTest {
    private final LottoWinningStatisticsService lottoWinningStatisticsService = new LottoWinningStatisticsService();

    static Stream<Arguments> getLottoWinningStatisticsServiceTestArgument() {
        return Stream.of(
                Arguments.of(createLottoPurchase(
                                createLottoPurchaseAmount(2000),
                                List.of(createLotto(1, 2, 3, 4, 5, 6), createLotto(3, 4, 5, 10, 15, 16))),
                        createWinningLotto(createLotto(2, 3, 4, 5, 6, 7), createBonusBall(1)),
                        1500250f,
                        List.of(LottoRank.SECOND, LottoRank.FIFTH)),
                Arguments.of(createLottoPurchase(
                                createLottoPurchaseAmount(1000),
                                List.of(createLotto(11, 12, 13, 14, 15, 16))),
                        createWinningLotto(createLotto(2, 3, 4, 5, 6, 7), createBonusBall(1)),
                        0f,
                        List.of(LottoRank.NO_RANK)));
    }

    @MethodSource("getLottoWinningStatisticsServiceTestArgument")
    @ParameterizedTest
    void 구입한로또의_당첨결과를_계산한다(LottoPurchase lottoPurchase, WinningTicket winningTicket, float profitRate,
                           List<LottoRank> winningResult) {
        //given
        //when
        WinningLottoResultDto lottoResult = lottoWinningStatisticsService.getWinningStatistics(lottoPurchase,
                winningTicket);
        //then
        assertThat(lottoResult.profitRate()).isEqualTo(profitRate);
        assertThat(lottoResult.winningResult())
                .containsExactlyElementsOf(winningResult);
    }
}