package lotto.service;

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
        assertThat(winningResult.getResult().get(FIRST_PLACE)).isEqualTo(1);
        assertThat(winningResult.getResult().get(SECOND_PLACE)).isEqualTo(1);
        assertThat(winningResult.getResult().get(THIRD_PLACE)).isEqualTo(1);
        assertThat(winningResult.getResult().get(NO_RANK)).isEqualTo(1);
    }

    private WinningLotto setupWinningLotto() {
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setWinningLotto(new Lotto(List.of(3,4,5,6,10,20)));
        winningLotto.setBonusNumber(40);
        return winningLotto;
    }

    Lottos setupLottos() {
        Lottos lottos = new Lottos(4000);
        lottos.addLotto(new Lotto(List.of(1,20,3,4,5,6)));
        lottos.addLotto(new Lotto(List.of(10,20,3,40,5,6)));
        lottos.addLotto(new Lotto(List.of(10,20,6,5,4,3)));
        lottos.addLotto(new Lotto(List.of(1,2,3,40,16,22)));
        return lottos;
    }
}