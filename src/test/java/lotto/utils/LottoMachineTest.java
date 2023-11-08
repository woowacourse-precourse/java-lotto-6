package lotto.utils;

import lotto.domain.Lotto;
import lotto.exception.LottoGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class LottoMachineTest {

    @DisplayName("로또 생성 테스트")
    @Test
    public void testCreateLotto() throws LottoGameException {
        Lotto lotto = LottoMachine.createLotto();

        assertNotNull(lotto);

        assertEquals(6, lotto.getLottoNumbers().size());
    }
}
