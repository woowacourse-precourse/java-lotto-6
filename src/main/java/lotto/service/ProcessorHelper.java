package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoArrays;

import java.util.List;

public class ProcessorHelper {

    public LottoArrays createLottoNumber(int purchaseCount){
        LottoArrays lottoArrays = new LottoArrays();

        for(int cnt = 0; cnt < purchaseCount; cnt ++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoArrays.addLottoArray(lotto);
        }
        return lottoArrays;
    }

    public void printLottoArrays(LottoArrays lottoArrays){
        for(Lotto lotto : lottoArrays.getLottoList()){
            System.out.println(lotto.toString());
        }
    }
}
