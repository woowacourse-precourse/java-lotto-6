package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Model.Lotto;

public class Generator {

    public static List<Lotto> generateLotto(Integer buyCount){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<buyCount; i++){
            Lotto lotto = generateNumbers();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public static Lotto generateNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(numbers);
    }
}
