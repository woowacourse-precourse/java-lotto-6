package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static Lotto generateRandomLotto(){
        List<Integer> randNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randNumbers);
    }
    public static List<Lotto> generateLottos(int n){
        List<Lotto> lottos=new ArrayList<>();
        for(int i=0;i<n;i++){
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }
}
