package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.NumberConstant;

public class LottoMachine {
    private final List<Lotto> lottos;

    public LottoMachine(int money){
        validMoney(money);
        int count = getLottoCount(money);
        lottos = createLottos(count);
    }

    private void validMoney(int money){
        if (money % NumberConstant.LOTTO_PRICE != NumberConstant.DEFAULT_VALUE){
            throw new IllegalArgumentException();
        }
    }

    private int getLottoCount(int money){
        validMoney(money);
        return money / NumberConstant.LOTTO_PRICE;
    }

    private List<Integer> makeRandomLotto(){
        return Randoms.pickUniqueNumbersInRange(NumberConstant.MIN_NUMBER, NumberConstant.MAX_NUMBER, NumberConstant.LOTTO_RANGE);
    }

    private List<Lotto> createLottos(int count){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = NumberConstant.DEFAULT_VALUE; i < count; i++){
            Lotto lotto = new Lotto(makeRandomLotto());
            lottos.add(lotto);
        }
        return lottos;
    }
}
