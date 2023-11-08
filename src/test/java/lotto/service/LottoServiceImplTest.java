package lotto.service;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
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
}