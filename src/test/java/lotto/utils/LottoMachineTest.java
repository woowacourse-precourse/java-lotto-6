package lotto.utils;

import lotto.domain.Lotto;
import lotto.exception.LottoGameException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LottoMachineTest {

    @DisplayName("로또 생성 테스트")
    @Test
    public void testCreateLotto() throws LottoGameException {
        Lotto lotto = LottoMachine.createLotto();

        assertNotNull(lotto);

        assertEquals(6, lotto.getLottoNumbers().size());
    }
}
