package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    public List<Lotto> lottoList;

    public LottoList(int i) {
        LottoListAdd(i);
    }
    private void LottoListAdd(int n){
        for(int i = 0 ;i < n; i++){
            lottoList.add(new Lotto(LottoGenerate()));
        }
    }

    private List<Integer> LottoGenerate(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
