package lotto.v3.controller;

import lotto.v3.view.LottoPurchaseView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.v3.util.LottoConstants.LOTTO_PRICE;

@DisplayName("LottoPurchaseController 테스트")
class LottoPurchaseControllerTest {

    private FakeLottoPurchaseView fakeView;
    private LottoPurchaseController controller;

    @BeforeEach
    void setUp() {
        fakeView = new FakeLottoPurchaseView();
        controller = new LottoPurchaseController(fakeView);
    }

    @Test
    @DisplayName("유효한 구입 금액은 예외를 발생시키지 않고, 올바른 티켓 수를 출력해야 한다")
    void validPurchaseAmountShouldNotThrowExceptionAndPrintCorrectNumberOfTickets() {
        // Given
        int validAmount = LOTTO_PRICE.getValue() * 3;
        fakeView.setPurchaseAmount(validAmount);

        // When
        controller.startPurchaseProcess();

        // Then
        assertThat(fakeView.getDisplayedNumberOfTickets()).isEqualTo(validAmount / LOTTO_PRICE.getValue());
    }

    @Test
    @DisplayName("구입 금액이 0인 경우 IllegalArgumentException을 발생시킨다")
    void zeroPurchaseAmountShouldThrowException() {
        // Given
        fakeView.setPurchaseAmount(0);

        // When & Then
        assertThatThrownBy(() -> controller.startPurchaseProcess())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 " + LOTTO_PRICE.getValue() + "원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000단위가 아닌  경우 IllegalArgumentException을 발생시킨다")
    void purchaseAmountNotInThousandsShouldThrowIllegalArgumentException() {
        // Given
        fakeView.setPurchaseAmount(1500);

        // When & Then
        assertThatThrownBy(() -> controller.startPurchaseProcess())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 " + LOTTO_PRICE.getValue() + "원 단위로 입력해야 합니다.");
    }

    private static class FakeLottoPurchaseView extends LottoPurchaseView {
        private int purchaseAmount;
        private int displayedNumberOfTickets;

        public void setPurchaseAmount(int purchaseAmount) {
            this.purchaseAmount = purchaseAmount;
        }

        public int getDisplayedNumberOfTickets() {
            return displayedNumberOfTickets;
        }

        @Override
        public int requestPurchaseAmount() {
            return purchaseAmount;
        }

        @Override
        public void displayNumberOfLottoTicketsPurchased(int numberOfLottoTickets) {
            this.displayedNumberOfTickets = numberOfLottoTickets;
        }
    }
}
