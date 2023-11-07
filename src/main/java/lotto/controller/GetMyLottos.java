package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.model.GameMoney;

import java.util.ArrayList;
import java.util.List;

public class GetMyLottos {

    public List<Lotto> getMyLottos(GameMoney gameMoney){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i< gameMoney.getGameCount(); i++){
            Lotto lotto=getMyLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto getMyLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

}
