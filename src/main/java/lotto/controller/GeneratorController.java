package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.UnitNumber;
import lotto.model.generator.Lotto;
import lotto.view.LottoOutputView;

public class GeneratorController {
    private final List<Lotto> lottoPurchaseNumbers = new ArrayList<>();

    public List<Lotto> printLottoController(int purchase) {
        int lottoPurchaseCount = purchase / UnitNumber.LOTTO_PRICE.getNumber();
        LottoOutputView.printLottoPurchaseCount(lottoPurchaseCount);
        for(int i = 0; i<lottoPurchaseCount; i++) {
            lottoPurchaseNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            LottoOutputView.printLottoNumbers(lottoPurchaseNumbers.get(i).getNumbers());
        }
        return lottoPurchaseNumbers;
    }
}
