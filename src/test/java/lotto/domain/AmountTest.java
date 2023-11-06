package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmountTest {

    @Test
    public void 도메인생성테스트(){
        Amount amount = new Amount(10000, 100);

        Assertions.assertThat(amount.getCount()).isEqualTo(amount.getCount());
    }
}
