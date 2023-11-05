package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoCount;
import domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {
    @DisplayName("로또 개수가 정상적으로 생성되는지 확인한다.")
    @Test
    void createLottoCount() {
        Money money = new Money("8000");
        long expectedLottoCount = money.getMoney() / 1000;
        LottoCount lottoCount = new LottoCount(money.getMoney());

        assertThat(lottoCount.getLottoCount()).isEqualTo(expectedLottoCount);
    }
}
