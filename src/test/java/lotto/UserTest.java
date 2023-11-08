package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.models.Machine;
import lotto.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    private Machine machine = new Machine();
    private User user = new User();

    @DisplayName("로또 구매 테스트")
    @Test
    void buyLotteriesTest(){
        user.setMoney(14000);
        int count = 0;
        while(user.hasMoney()){
            count ++;
            user.buyLottery(machine);
        }
        assertThat(count).isEqualTo(14);
    }
}
