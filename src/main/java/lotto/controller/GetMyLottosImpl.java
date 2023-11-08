package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.model.GameMoney;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetMyLottosImpl implements GetMyLottos{

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
        List<Integer> mutableList = new ArrayList<>(numbers); // 변경 가능한 컬렉션으로 변환 또는 복사
        Collections.sort(mutableList);

        Lotto lotto = new Lotto(mutableList);
        return lotto;
    }

}
