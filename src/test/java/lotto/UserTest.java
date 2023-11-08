package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.models.Machine;
import lotto.models.User;
import lotto.views.OutputView;
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

    @DisplayName("로또 출력 테스트")
    @Test
    void printLotteries(){
        user.setMoney(10000);
        while(user.hasMoney()){
            user.buyLottery(machine);
        }
        OutputView outputView = new OutputView();
        outputView.printLotteries(user.getLotteries());
    }
}
