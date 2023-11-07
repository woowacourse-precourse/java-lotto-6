package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoSet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;



public class LottoSetTest {
    @DisplayName("로또 set 생 테스트")
    @Test
    void generateLottoSetTest() {
        int quantity = 6;
        LottoSet lottoSet = new LottoSet(6);
        Assertions.assertThat(lottoSet.getLottoSet()).isNotNull().hasSize(quantity);
    }
}
