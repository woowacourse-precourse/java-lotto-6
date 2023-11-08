package lotto;

import lotto.domain.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.constant.ErrorConst.PRICE_LESS_THAN_THOUSAND;
import static lotto.domain.constant.ErrorConst.PRICE_NOT_DIVIDED_BY_THOUSAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LotteriesPurchaseTest {

    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다")
    void buyLotteriesByMoneyNotDivided1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoService.buyLotteries(1234);
        }).withMessage(PRICE_NOT_DIVIDED_BY_THOUSAND);
    }

    @Test
    @DisplayName("구입 금액이 1000보다 작으면 예외가 발생한다")
    void buyLotteriesByMoneyLessThan1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoService.buyLotteries(999);
        }).withMessage(PRICE_LESS_THAN_THOUSAND);
    }

    @Test
    @DisplayName("모든 검증을 통과하면 금액에 알맞은 개수만큼 로또를 발행한다")
    void buyLotteriesSuccessfully() {
        lottoService.buyLotteries(5000);

        assertThat(lottoService)
                .extracting("lottoStorage")
                .asList().size().isEqualTo(5);
    }

}