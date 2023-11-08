package lotto.service;

import lotto.domain.WinningDetails;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceServiceTest {

    private PriceService priceService;

    @BeforeEach
    void beforeEach() {
        priceService = new PriceService();
    }

    @DisplayName("구매 금액이 1000원 단위로 입력되지 않는 경우 예외가 발생한다.")
    @Test
    void purchasePriceByInvalidLottoUnit() {

        int price = 1001;

        assertThatThrownBy(() -> priceService.setPurchasePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INCORRECT_UNIT.getMessage());
    }

    @DisplayName("구매 금액이 정상적으로 입력되었다면, 구매 개수를 로또 금액에 맞게 가져와야 한다.")
    @Test
    void lottoPurchaseQuantity() {

        int price = 2000;
        int quantity = 2;

        priceService.setPurchasePrice(price);

        assertThat(priceService.getLottoPurchaseQuantity()).isEqualTo(quantity);

    }

    @DisplayName("당첨 결과에 따라서 총 수익률을 계산해야한다.")
    @Test
    void calculateEarningRateTest() {

        int purchasePrice = 5000;
        float earningRate = 100.0f;
        WinningDetails winningDetails = new WinningDetails();
        winningDetails.increaseCount(5);

        priceService.setPurchasePrice(purchasePrice);
        priceService.calculateWinningPrice(winningDetails);

        assertThat(priceService.getEarningRate()).isEqualTo(earningRate);
    }
}
