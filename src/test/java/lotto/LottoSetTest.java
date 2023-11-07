package lotto;

import lotto.domain.LottoSet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoSetTest {
    @DisplayName("로또 set 생성 테스트")
    @Test
    void generateLottoSetTest() {
        int quantity = 6;
        LottoSet lottoSet = new LottoSet(6);
        Assertions.assertThat(lottoSet.getLottoSet()).isNotNull().hasSize(quantity);
    }
}
