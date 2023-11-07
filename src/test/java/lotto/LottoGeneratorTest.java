package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void generateLottoNumbers() {
        int purchaseAmount = 5000;

        List<Lotto> lottoTickets = LottoGenerator.generateLottoNumbers(purchaseAmount);

        int expectedLottoCount = purchaseAmount / 1000;
        assertEquals(expectedLottoCount, lottoTickets.size());
    }
}