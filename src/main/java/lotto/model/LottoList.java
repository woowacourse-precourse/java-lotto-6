package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

    private final List<Lotto> lottoList = new ArrayList<>();
    public List<Lotto> getLottoList() {
        return lottoList;
    }


    public LottoList(int i) {
        int num = i/1000;
        LottoListAdd(num);
    }
    private void LottoListAdd(int num){
        for(int i = 0 ;i < num; i++){
            lottoList.add(new Lotto(LottoGenerate()));
        }
    }

    private List<Integer> LottoGenerate(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
