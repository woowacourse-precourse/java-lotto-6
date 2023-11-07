package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService;

    LottoServiceTest() {
        this.lottoService = new LottoService();
    }

    @DisplayName("로또 구입 금액 단위가 1,000원이 아니면 false")
    @Test
    void invalidPurchasePriceTest() {
        assertThat(lottoService.validatePurchasePrice(1)).isFalse();
        assertThat(lottoService.validatePurchasePrice(1001)).isFalse();
        assertThat(lottoService.validatePurchasePrice(1000)).isTrue();
    }

    @DisplayName("입력 받은 로또 구입 금액만큼 로또 발행")
    @Test
    void createLottoByPurchasePrice() {
        assertThat(lottoService.issueLotto(2000).size() == 2).isTrue();
    }
}