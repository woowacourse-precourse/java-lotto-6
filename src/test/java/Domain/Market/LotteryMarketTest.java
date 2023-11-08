package Domain.Market;

import camp.nextstep.edu.missionutils.Randoms;
import Domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryMarketTest {
    @DisplayName("금액에 맞는 로또를 발급한다.")
    @Test
    void createLottoByMoney() {
        List<Integer> numList = Randoms.pickUniqueNumbersInRange(1,20,5);

        for(int num: numList){
            int money = num * 1000;
            List<Lotto> lotteries = LotteryMarket.issueLotteries(money);
            assertThat(lotteries.size()).isEqualTo(num);
        }
    }

    @DisplayName("1~45 사이의 숫자만 생성한다.")
    @Test
    void createLottoWithRightNumber(){
        for(int i=0;i<5;i++){
            Lotto lotto = LotteryMarket.issueLotto();
            assertThat(lottoNumInRange(1, 45, lotto)).isEqualTo(true);
        }
    }

    boolean lottoNumInRange(int start, int end, Lotto lotto){
        for(Integer num: lotto.getNumbers()){
            if(num < start || num > end)
                return false;
        }
        return true;
    }
}
