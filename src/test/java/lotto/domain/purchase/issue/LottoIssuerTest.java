package lotto.domain.purchase.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @Test
    @DisplayName("중복수가 없는 6자리의 로또 발행")
    void 로또발행() {
        // WHEN
        Lotto lotto = LottoIssuer.issueLotto();

        // THEN
        assertEquals(lotto.getSize(), 6);
    }
}