package lotto.model;

import static lotto.constant.LottoConstant.FIFTH_PLACE_MATCH_COUNT;
import static lotto.constant.LottoConstant.FIRST_PLACE_MATCH_COUNT;
import static lotto.constant.LottoConstant.FOURTH_PLACE_MATCH_COUNT;
import static lotto.constant.LottoConstant.SECOND_THIRD_PLACE_MATCH_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.constant.NumberConstant;

public class LottoMachine {
    private List<Lotto> lottos;

    public LottoMachine(int money){
        int count = getLottoCount(money);
        this.lottos = createLottos(count);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    //로또 생성
    private List<Lotto> createLottos(int count){
        List<Lotto> newLottos = new ArrayList<>();
        for(int i = NumberConstant.DEFAULT_VALUE; i < count; i++){
            Lotto lotto = new Lotto(makeRandomLotto());
            newLottos.add(lotto);
        }
        return newLottos;
    }

    private int getLottoCount(int money){
        return money / NumberConstant.LOTTO_PRICE;
    }

    private List<Integer> makeRandomLotto(){
        return Randoms.pickUniqueNumbersInRange(NumberConstant.MIN_NUMBER, NumberConstant.MAX_NUMBER, NumberConstant.LOTTO_RANGE);
    }
}
