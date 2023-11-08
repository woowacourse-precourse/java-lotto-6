package Domain.Market;

import camp.nextstep.edu.missionutils.Randoms;
import Domain.lotto.Lotto;
import Domain.lotto.LottoPrice;

import java.util.ArrayList;
import java.util.List;

public class LotteryMarket {
    //들어온 money와 LotteryPrice에 맞춰 Lotto를 List에 담아 return.
    public static List<Lotto> issueLotteries(int money){
        int num = money / LottoPrice.nomal.getValue();
        List<Lotto> ret = new ArrayList<>();
        for(int i=0;i<num;i++){
            ret.add(issueLotto());
        }
        return ret;
    }

    public static Lotto issueLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
