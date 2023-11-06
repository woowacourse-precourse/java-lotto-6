package lotto.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyTest {

    @DisplayName("구매한 로또 수와 발행한 개수가 같은 경우 성공한다.")
    @Test
    void createLottoByPublishSize() {
        int amount = 5000;
        Buy info = new Buy(new ArrayList<>());

        int actual = info.createToLotto(amount);

        assertThat(actual).isEqualTo(info.getBuyLottoNumbers().size());
    }
}