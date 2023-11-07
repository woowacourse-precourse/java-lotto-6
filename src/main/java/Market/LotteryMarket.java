package Market;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.List;

public class LotteryMarket {

    //복권 가격
    int LotteryPrice = 1000;

    //들어온 money와 LotteryPrice에 맞춰 Lotto를 List에 담아 return.
    public List<Lotto> issueLotteries(int money){

    }

    public Lotto issueLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
