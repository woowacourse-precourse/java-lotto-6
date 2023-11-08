package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final static Integer START = 0;
    private Lottos lottos;
    private BuyAmount buyAmount;

    public LottoController() {
        buyLotto();
        showLotto();
    }

    protected void buyLotto() {
        Output.printBuyAmount();
        buyAmount = new BuyAmount(Input.user());
        List<Lotto> lottos = new ArrayList<>();
        for(int i = START; i < buyAmount.getBuyCount(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        this.lottos = new Lottos(lottos);

    }

    private void showLotto() {
        Output.printBuyCount(buyAmount.getBuyCount());
        for(Lotto lotto : this.lottos.getLottos()) {
            List<Integer> lottoNumber = lotto.getLotto();
            Output.printLottoNumber(Arrays
                    .toString(lottoNumber
                            .stream()
                            .mapToInt(Integer::intValue)
                            .toArray()));
        }
    }


}
