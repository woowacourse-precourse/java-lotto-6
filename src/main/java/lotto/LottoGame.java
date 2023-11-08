package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    public List<Lotto> generateLottos(int gameNumber){
        List<Lotto> ret=new ArrayList<>();
        for(int i=0;i<gameNumber;i++){
            ret.add(new Lotto(generateLottoNumbers()));
        }
        return ret;
    }

    public List<Integer> generateLottoNumbers(){
        List<Integer> eachLottoList=Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(eachLottoList);
        return eachLottoList;
    }

}
