package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.NumberConstant;

public class LottoMachine {
    private final List<Lotto> lottos;

    public LottoMachine(int money){
        int count = getLottoCount(money);
        lottos = createLottos(count);
    }

    private List<Lotto> createLottos(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = NumberConstant.DEFAULT_VALUE; i < count; i++){
            Lotto lotto = new Lotto(makeRandomLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

    private int getLottoCount(int money){
        return money / NumberConstant.LOTTO_PRICE;
    }

    private List<Integer> makeRandomLotto(){
        return Randoms.pickUniqueNumbersInRange(NumberConstant.MIN_NUMBER, NumberConstant.MAX_NUMBER, NumberConstant.LOTTO_RANGE);
    }


}
