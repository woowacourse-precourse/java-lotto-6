package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class LottoMachineTest {
    private LottoGenerator generator;
    private LottoMachine machine;
    @BeforeEach
    public void setUp() {
        // LottoGenerator를 목 객체로 생성
        generator = Mockito.mock(LottoGenerator.class);
        machine = new LottoMachine(generator);
    }

    @Test
    @DisplayName("정확한 수의 로또 티켓을 구매해야 한다")
    public void testPurchaseLottos() {
        // 기대하는 로또 번호 설정
        Lotto expectedLotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto expectedLotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        when(generator.generate()).thenReturn(expectedLotto1, expectedLotto2);

        // 로또 구매
        machine.purchaseLottos(2);

        // 구매된 로또 수 확인
        List<Lotto> purchasedLottos = machine.getPurchasedLottos();
        assertEquals(2, purchasedLottos.size(), "2장의 로또를 구매해야 한다");

        // 구매된 로또가 기대한 로또와 일치하는지 확인
        assertEquals(expectedLotto1, purchasedLottos.get(0), "첫 번째 구매한 로또가 기대한 로또와 일치해야 한다");
        assertEquals(expectedLotto2, purchasedLottos.get(1), "두 번째 구매한 로또가 기대한 로또와 일치해야 한다");
    }
}
