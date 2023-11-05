package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.util.Constant;
import org.junit.jupiter.api.Test;

class IssueLottoTest {

    @Test
    void 로또_발행() {
        IssueLotto issueLotto = new IssueLotto();
        issueLotto.issue(8);

        assertThat(issueLotto.getLottoPurchaseHistory().get(0)
                .getNumbers().size()).isEqualTo(Constant.LOTTO_PICK_COUNT);
        assertThat(issueLotto.getLottoPurchaseHistory().size()).isEqualTo(8);
    }
}