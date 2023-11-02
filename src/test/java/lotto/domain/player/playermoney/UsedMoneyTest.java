package lotto.domain.player.playermoney;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsedMoneyTest {

    @Test
    void ConsumeMoneyTest() {
        UsedMoney usedMoney = new UsedMoney(0);
        usedMoney = usedMoney.updateUsedMoney(2000);
        Assertions.assertThat(usedMoney.getUsedMoney()).isEqualTo(2000);
    }
}
