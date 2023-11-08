package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.model.Lotto.*;

public class Lottos {
    private List<Lotto> lottoList;
    private Money money;

    public Lottos(Money money){
        this.money = money;
        this.lottoList = new ArrayList<Lotto>();
    }

    public void addLottoList(){
        for (int i = 0; i<money.getPlayCount(); i++){
            lottoList.add(makeLotto());
            System.out.println(lottoList.get(i).getNumbers());
        }
    }
    public List<Lotto> getLottoList(){
        return this.lottoList;
    }

    public Lotto makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO,MAX_LOTTO,LOTTO_NUM_COUNT);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
