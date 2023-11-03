package lotto.domain.player.playermoney;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsedMoneyTest {

    @DisplayName("사용하는 금액 만큼 usedMoney 가 업데이트 된다.")
    @Test
    void ConsumeMoneyTest() {
        UsedMoney usedMoney = new UsedMoney(0);
        usedMoney = usedMoney.updateUsedMoney(2000);
        Assertions.assertThat(usedMoney.getUsedMoney()).isEqualTo(2000);
    }
}
