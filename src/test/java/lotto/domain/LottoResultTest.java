package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("각 로또에 대해 당첨 번호와 비교해서 결과를 만든다.")
    @ParameterizedTest
    @MethodSource("lottoTicketInfo")
    void createLottoResultTest(List<Lotto> lottoTicket) {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoResult lottoResult = new LottoResult(lottoTicket, winningLottoNumbers);
        EnumMap<LottoPrize, Integer> lottoPrizeResult = lottoResult.getLottoResult();

        assertThat(lottoPrizeResult.get(LottoPrize.PRIZE_1ST)).isEqualTo(1);
        assertThat(lottoPrizeResult.get(LottoPrize.PRIZE_2ND)).isEqualTo(1);
        assertThat(lottoPrizeResult.get(LottoPrize.PRIZE_3RD)).isEqualTo(1);
        assertThat(lottoPrizeResult.get(LottoPrize.PRIZE_4TH)).isEqualTo(1);
        assertThat(lottoPrizeResult.get(LottoPrize.PRIZE_5TH)).isEqualTo(1);
        assertThat(lottoPrizeResult.get(LottoPrize.NOTHING)).isEqualTo(1);
    }

    static List<List<Lotto>> lottoTicketInfo() {
        return List.of(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                        new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                        new Lotto(List.of(10, 11, 12, 13, 14, 15))
                )
        );
    }

    @DisplayName("로또 당첨 결과 금액을 계산한다.")
    @ParameterizedTest
    @MethodSource("lottoTicketInfo")
    void calculateTotalPrizeTest(List<Lotto> lottoTicket) {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoResult lottoResult = new LottoResult(lottoTicket, winningLottoNumbers);

        assertThat(lottoResult.calculateTotalPrize()).isEqualTo(
                LottoPrize.PRIZE_1ST.getPrize().getMoney() +
                        LottoPrize.PRIZE_2ND.getPrize().getMoney() +
                        LottoPrize.PRIZE_3RD.getPrize().getMoney() +
                        LottoPrize.PRIZE_4TH.getPrize().getMoney() +
                        LottoPrize.PRIZE_5TH.getPrize().getMoney()
        );
    }
}