package lotto.service;

import static lotto.enums.WinningRankType.FIFTH_PLACE;
import static lotto.enums.WinningRankType.FIRST_PLACE;
import static lotto.enums.WinningRankType.FOURTH_PLACE;
import static lotto.enums.WinningRankType.NO_RANK;
import static lotto.enums.WinningRankType.SECOND_PLACE;
import static lotto.enums.WinningRankType.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

import lotto.domain.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceImplTest {
    LottoService lottoService = LottoServiceImpl.getInstance();

    private WinningLotto setupWinningLotto() {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setWinningLotto(new Lotto(List.of(1,2,3,4,5,6)));
        winningLotto.setBonusNumber(7);
        return winningLotto;
    }

    Lottos setupLottos() {
        Lottos lottos = new Lottos(4000);
        lottos.addLotto(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.addLotto(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.addLotto(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.addLotto(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.addLotto(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.addLotto(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.addLotto(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.addLotto(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        return lottos;
    }

    @DisplayName("구입 금액만큼 로또 구매하기")
    @Test
    void testBuyLottos() {
        assertThat(lottoService.buyLottos("3000").getLottos().size())
                .isEqualTo(3);
    }

    @DisplayName("당첨 번호 추첨하기")
    @Test
    void testDrawWinningNumbers() {
        assertThat(lottoService.drawWinningNumbers("10,11,12,13,14,15").getNumbers())
                .contains(10, 11, 12, 13, 14, 15);
    }

    @DisplayName("보너스 번호 추첨하기")
    @Test
    void testDrawBonusNumber() {
        assertThat(lottoService.drawBonusNumber("45"))
                .isEqualTo(45);
    }

    @DisplayName("당첨 순위 매칭하기")
    @Test
    void testMatchRankType() {
        Lotto lotto = new Lotto(List.of(11,22,3,4,5,6));
        WinningLotto winningLotto = setupWinningLotto();

        assertThat(lottoService.matchRankType(lotto, winningLotto))
                .isEqualTo(FOURTH_PLACE);
    }

    @DisplayName("당첨 순위 카운팅하기")
    @Test
    void testCalculateWinning() {
        WinningResult winningResult = lottoService.calculateWinning(setupLottos(), setupWinningLotto());
        assertThat(winningResult.getResult().get(FIFTH_PLACE)).isEqualTo(1);
        assertThat(winningResult.getResult().get(NO_RANK)).isEqualTo(7);
    }

    @DisplayName("수익률 계산하기")
    @Test
    void testCalculateRateOfReturn() {
        WinningResult winningResult = lottoService.calculateWinning(setupLottos(), setupWinningLotto());
        assertThat(String.format("%.1f", lottoService.calculateRateOfReturn(winningResult, 8000)))
                .isEqualTo("62.5");
    }
}