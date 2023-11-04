package domain;

import util.CreateRandomNumberUtil;
import util.MessageUtil;

import java.util.List;

public class LottoPurchase {

    private Lotto getRandomLottoNum(){
        // 로또 넘버 하나! 랜덤 생성 하고 lotto 객체 반환
        List<Integer> randomLottoNums = CreateRandomNumberUtil.getNumbers();
        Lotto lotto = new Lotto(randomLottoNums);
        MessageUtil.printPurchaseInfo(lotto.getLottoNumbers());
        return lotto;
    }
}
