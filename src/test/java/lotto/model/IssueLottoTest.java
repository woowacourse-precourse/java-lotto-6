package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.util.Constant;
import org.junit.jupiter.api.Test;

class IssueLottoTest {

    @Test
    void 로또_발행() {
        List<Lotto> purchaseHistory = IssueLotto.createIssueLotto().issue(8);

        assertThat(purchaseHistory.get(0)
                .getNumbers().size()).isEqualTo(Constant.NUMBER_PICK_COUNT);
        assertThat(purchaseHistory.size()).isEqualTo(8);
    }
}