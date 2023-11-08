package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.validator.LottoRule;

public class LottoMachine {
    List<Lotto> lottos = new ArrayList<>();
    List<Integer> lottoNum;

    public List<Lotto> makeLottosByPurchaseAmount(int amount){
        for(int i=0; i<amount; i++){
            lottos.add(makeLottoByRandom());
        }
        return lottos;
    }
    public Lotto makeLottoByRandom(){
        lottoNum = Randoms.pickUniqueNumbersInRange(LottoRule.LOTTO_START_NUM, LottoRule.LOTTO_END_NUM, LottoRule.LOTTO_NUMBER_LENGTH);
        Lotto lotto = new Lotto(lottoNum);
        return lotto;
    }
}
