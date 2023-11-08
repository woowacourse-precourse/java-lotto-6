package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeneratorLottoTest {
    @DisplayName("구매한 로또 수량 만큼 로또가 생성되는지 테스트")
    @Test
    void testPurchaseQuantityCreatesLotto(){
        List<Lotto> lottoList = GeneratorLotto.generateLottoTickets(3);
        assertEquals(3, lottoList.size());
    }
}