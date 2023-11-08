package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("5000원이 주어질 때, 5장의 로또를 계산한다.")
    @Test
    public void given_5000Won_when_CalculateNumberOfTickets_then_Returns5Tickets() {
        assertEquals(5, lottoMachine.calculateNumberOfTickets(5000));
    }

    @DisplayName("800원이 주어질 때, 예외가 발생한다.")
    @Test
    public void given_800Won_when_CalculateNumberOfTickets_then_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> lottoMachine.calculateNumberOfTickets(800));
    }

    @Test
    @DisplayName("5000원이 주어질 때, 5장의 로또가 생성된다.")
    public void given_5000Won_when_PurchaseLottos_then_Returns5Lottos() {
        List<Lotto> lottos = lottoMachine.purchaseLottos(5000);

        assertEquals(5, lottos.size());
    }

    @Test
    @DisplayName("4500원이 주어질 때, 에러가 발생한다.")
    public void given_4500Won_when_Purchase_Lottos_then_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> lottoMachine.purchaseLottos(4500));
    }
}