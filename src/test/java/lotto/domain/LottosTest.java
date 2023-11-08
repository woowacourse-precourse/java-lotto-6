package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.generator.LottoNumbersGenerator;
import lotto.generator.LottosGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottosTest {

    @DisplayName("발행 개수만큼 로또 생성되는지 ")
    @Test
    void create() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        LottosGenerator lottosGenerator = LottosGenerator.create(lottoNumbersGenerator);
        TicketCount ticketCount = TicketCount.create(PurchaseAmount.create(2000));
        Lottos lottos = Lottos.create(ticketCount, lottosGenerator);
        assertEquals(2, lottos.getLottos().size());
    }
}
