package lotto.service;

import static lotto.enums.WinningRankType.FOURTH_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

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
        Lotto lotto = new Lotto(List.of(11,22,33,44,15,26));
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setWinningLotto(new Lotto(List.of(11,22,33,44,35,36)));
        winningLotto.setBonusNumber(15);

        assertThat(lottoService.matchRankType(lotto, winningLotto))
                .isEqualTo(FOURTH_PLACE);
    }

}