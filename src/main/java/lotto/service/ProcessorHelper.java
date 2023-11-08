package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoArrays;
import lotto.model.PurchaseInfo;

import java.util.List;

public class ProcessorHelper {

    public LottoArrays createAndPrintLottoNumber(PurchaseInfo purchaseInfo){
        LottoArrays lottoArrays = createLottoNumber(purchaseInfo);
        for(Lotto lotto : lottoArrays.getLottoList()){
            System.out.println(lotto.toString());
        }
        return lottoArrays;
    }
    public LottoArrays createLottoNumber(PurchaseInfo purchaseInfo){
        LottoArrays lottoArrays = new LottoArrays();

        for(int cnt = 0; cnt < purchaseInfo.getPurchaseCount(); cnt ++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoArrays.addLottoArray(lotto);
        }
        return lottoArrays;
    }



}
