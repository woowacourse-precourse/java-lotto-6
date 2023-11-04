package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private LottoFactory lottoFactory;
    private LottoTickets lottoTickets;
    private LottoMachine lottoMachine;
    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
        lottoFactory = new LottoFactory(lottoNumberGenerator);
        lottoTickets = new LottoTickets();
        lottoMachine = new LottoMachine(lottoFactory, lottoTickets);
    }

    @DisplayName("구매 금액이 1000원 단위가 아닐 경우 예외를 발생시킨다")
    @Test
    void testPurchaseWithInvalidAmount() {
        int invalidPurchaseAmount = 1500;
        assertThatThrownBy(() -> lottoMachine.purchaseLottoTickets(invalidPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주어진 금액으로 적절한 수의 로또 티켓을 생성한다")
    @Test
    void testPurchaseLottoTickets() {
        int purchaseAmount = 3000;
        lottoMachine.purchaseLottoTickets(purchaseAmount);

        assertEquals(3, lottoTickets.getLottoTickets().size());
    }

}