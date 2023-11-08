package lotto;

import lotto.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {
    @Test
    @DisplayName("횟수 계산 확인 테스트")
    void testCalculationLoopCount(){
        User user = new User();
        user.setMoney(20000);
        user.calculationLoopCount();
        assertThat(user.getLoopCount()).isEqualTo(20);
    }
    
}
