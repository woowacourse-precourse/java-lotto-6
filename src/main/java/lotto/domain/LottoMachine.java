package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.utils.Parser;

import java.util.List;

public class LottoMachine {
    private int coin;

    LottoMachine(PurchaseAmount purchaseAmount){
        this.coin = Parser.parseAmountToLottoNumber(purchaseAmount);
    }

    public Lotto createLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(lottoNumbers);
    }
}
