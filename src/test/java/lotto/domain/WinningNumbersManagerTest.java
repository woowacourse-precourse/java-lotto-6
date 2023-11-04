package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        Map<WinningStatus, Integer> winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.get(WinningStatus.MATCH6)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 5개 일치 + 보너스볼 일치 당첨여부 계산")
    void 로또_5개_일치_보너스볼_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        //when
        Map<WinningStatus, Integer> winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.get(WinningStatus.MATCH5_WITH_BONUS)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 5개 일치 당첨여부 계산")
    void 로또_5개_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        //when
        Map<WinningStatus, Integer> winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.get(WinningStatus.MATCH5)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 4개 일치 당첨여부 계산")
    void 로또_4개_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));

        //when
        Map<WinningStatus, Integer> winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.get(WinningStatus.MATCH4)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 3개 일치 당첨여부 계산")
    void 로또_3개_일치_당첨여부_계산() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 7)));

        //when
        Map<WinningStatus, Integer> winningStatus = winningNumbersManager.getWinningStatus(lottos);

        //then
        assertThat(winningStatus.get(WinningStatus.MATCH3)).isEqualTo(1);
    }
}