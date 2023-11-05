package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersManagerTest {
    private static WinningNumbersManager winningNumbersManager;

    @BeforeAll
    static void init() {
        winningNumbersManager = new WinningNumbersManager();
        winningNumbersManager.inputWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        winningNumbersManager.inputBonusNumber(7);
    }

    @Test
    @DisplayName("로또 6개 일치 당첨여부 계산")
    void 로또_6개_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        //when
        WinningStatus winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.getSum(PrizeType.MATCH6)).isEqualTo(PrizeType.MATCH6.getPrize());
    }

    @Test
    @DisplayName("로또 5개 일치 + 보너스볼 일치 당첨여부 계산")
    void 로또_5개_일치_보너스볼_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        //when
        WinningStatus winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.getSum(PrizeType.MATCH5_WITH_BONUS)).isEqualTo(PrizeType.MATCH5_WITH_BONUS.getPrize());
    }

    @Test
    @DisplayName("로또 5개 일치 당첨여부 계산")
    void 로또_5개_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        //when
        WinningStatus winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.getSum(PrizeType.MATCH5)).isEqualTo(PrizeType.MATCH5.getPrize());
    }

    @Test
    @DisplayName("로또 4개 일치 당첨여부 계산")
    void 로또_4개_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));

        //when
        WinningStatus winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.getSum(PrizeType.MATCH4)).isEqualTo(PrizeType.MATCH4.getPrize());
    }

    @Test
    @DisplayName("로또 3개 일치 당첨여부 계산")
    void 로또_3개_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 7)));

        //when
        WinningStatus winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.getSum(PrizeType.MATCH3)).isEqualTo(PrizeType.MATCH3.getPrize());
    }
}